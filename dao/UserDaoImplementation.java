package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojos.User;

import static utils.DBUtils.*;

public class UserDaoImplementation implements UserDao
{
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4, pst5, pst6;
	
	public UserDaoImplementation() throws SQLException
	{
		cn = openConnection();
		
		pst1 = cn.prepareStatement("select * from users where email = ? and password = ?");
		
		pst2 = cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		
		pst3 = cn.prepareStatement("Update users set status = ? where id = ?");
		
		pst4 = cn.prepareStatement("delete from users where id = ?");
		
		pst5 = cn.prepareStatement("select * from users");
		
		pst6 = cn.prepareStatement("select first_name, email from users");
	}
	
	@Override
	public User authenticateUser(String email, String password) throws SQLException
	{
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		try(ResultSet rst = pst1.executeQuery())
		{
			if(rst.next())
			return new User(rst.getInt(1), rst.getString(2), rst.getString(3), 
					rst.getString(4), rst.getDate(5), rst.getBoolean(6), rst.getString(7));
		}
		return null;
	}
	
	@Override
	public String registerVoter(User voter) throws SQLException
	{
		pst2.setString(1, voter.getFirstName());
		pst2.setString(2, voter.getLastName());
		pst2.setString(3, voter.getEmail());
		pst2.setString(4, voter.getPassword());
		pst2.setDate(5, voter.getDob());
		pst2.setBoolean(6, false);
		pst2.setString(7, voter.getRole());
		
		int count = pst2.executeUpdate();
		if(count == 1)
			return "New voter details added successfully";
		return "Voter details not added";
	}
	
	@Override
	public 	String updateVotingStatus(int id) throws SQLException
	{
		pst3.setBoolean(1, true);
		pst3.setInt(2, id);
		
		int count = pst3.executeUpdate();
		if(count == 1)
			return "Voting status updated";
		return "Voting status updation failed";
	}
	public String deleteVoter(int id) throws SQLException
	{
		pst4.setInt(1, id);
		
		int count = pst4.executeUpdate();
		
		if(count == 1)
		{
			return "Voter removed successfully";
		}
		return "Enter valid voter id";
	}
	public List<User> displayAllVoter() throws SQLException
	{
		List<User> list = new ArrayList<>();
		
		try(ResultSet rst = pst5.executeQuery())
		{
			while(rst.next())
			{
				list.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3),
						rst.getString(4), rst.getString(5), rst.getDate(6),
						rst.getBoolean(7), rst.getString(8)));
			}
			return list;
		}
	}
	
	@Override
	public Map<String, String> displayFirstNameAndEmail() throws SQLException 
	{ 
		Map<String, String> map = new HashMap<>();
		
		try(ResultSet rst = pst6.executeQuery())
		{
			while(rst.next())
			{
				map.put(rst.getString(1), rst.getString(2));
			}
			return map;
		}
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if(pst2 != null)
			pst2.close();
		if(pst3 != null)
			pst3.close();
		if(pst4 != null)
			pst4.close();
		if(pst5 != null)
			pst5.close();
		if(pst6 != null)
			pst6.close();
	}

	
}
