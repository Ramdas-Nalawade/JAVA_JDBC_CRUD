package tester;

import java.util.Scanner;

import dao.UserDaoImplementation;

public class DeleteVoter {

	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			UserDaoImplementation userDao = new UserDaoImplementation();
			System.out.println("Enter your voter id:");
			
			System.out.println(userDao.deleteVoter(sc.nextInt()));
			userDao.cleanUp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
