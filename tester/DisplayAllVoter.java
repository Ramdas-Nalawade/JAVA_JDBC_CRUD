package tester;

import dao.UserDaoImplementation;

public class DisplayAllVoter {

	public static void main(String[] args) 
	{
		try
		{
			UserDaoImplementation userDao = new UserDaoImplementation();
			userDao.displayAllVoter().forEach(p->System.out.println(p));
			userDao.cleanUp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
