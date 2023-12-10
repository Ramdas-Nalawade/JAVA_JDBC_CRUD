package tester;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import dao.UserDaoImplementation;
import pojos.User;

import static utils.DBUtils.*;

public class RegisterVoter {

	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			UserDaoImplementation userDao = new UserDaoImplementation();
			System.out.println("Enter first_name,last_name,email,password,dob");
			
			User voter  = new User(sc.next(), sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next()));
			
			int age = Period.between(voter.getDob().toLocalDate(), LocalDate.now()).getYears();
			
			if(age >= 21)
			{
				System.out.println(userDao.registerVoter(voter));
			}
			else
			{
				System.out.println("Invalid age");
			}
			userDao.cleanUp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
