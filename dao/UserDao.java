package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import pojos.User;

public interface UserDao 
{
	User authenticateUser(String email, String password) throws SQLException;
	String registerVoter(User voter) throws SQLException;
	String updateVotingStatus(int id) throws SQLException;
	String deleteVoter(int id) throws SQLException;
	List<User> displayAllVoter() throws SQLException;
	Map<String, String> displayFirstNameAndEmail() throws SQLException;
}
