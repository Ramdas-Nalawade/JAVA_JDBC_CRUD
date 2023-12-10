package tester;

import java.util.Scanner;

import dao.UserDaoImplementation;

public class UpdateVotingStatus {

	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			UserDaoImplementation userDao = new UserDaoImplementation();
			System.out.println("Enter your id:");
			
			System.out.println(userDao.updateVotingStatus(sc.nextInt()));
			userDao.cleanUp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
