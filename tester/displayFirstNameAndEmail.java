package tester;

import java.util.Map;

import dao.UserDaoImplementation;

public class displayFirstNameAndEmail {

	public static void main(String[] args) 
	{
		try
		{
			UserDaoImplementation userDao = new UserDaoImplementation();
			Map<String, String> map = userDao.displayFirstNameAndEmail();
			
			map.forEach((k, v)->System.out.println(k+ " --> "+ v));
			userDao.cleanUp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
