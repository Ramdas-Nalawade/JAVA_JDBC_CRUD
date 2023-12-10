package tester;

import java.util.Scanner;
import  dao.UserDao;
import dao.UserDaoImplementation;
import pojos.User;

public class AuthenticateUser {

	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			UserDaoImplementation userDao = new UserDaoImplementation();
			System.out.println("Enter email and password:");
			
			User user = userDao.authenticateUser(sc.next(), sc.next());
			
			if(user == null)
			{
				System.out.println("Invalid credentials");
			}
			else
			{
				System.out.println("Logged in successfull !");
				System.out.println("User : " + user);
			}
			userDao.cleanUp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
