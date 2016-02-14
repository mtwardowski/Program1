/**
	Student.java
	
	@author	Michael Twardowski
	
	The Student class defines a student as having a name and grades.
	The following operations are available on a Student:
	. 	setup()				Initializes the student names and grades.
	.	display()			Prints the full name of the student and their grades to the console.
	.	overallGrade()		Returns (as a double) the overall grade(weighted course average) of the student.
*/

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student
{

	/**	
	 *	To hold the name of the student
	 */
	private	 String	fullName;

	/**	
	 *	To hold the individual grades
	 */						
	private Grades grades;	
	
	/**	
	 * Initializes the student names and grades.
	 */
	public void setup()
	{
		setName();
		grades = new Grades();
		setGrades();
	}
	
	/**The setName method initializes the name of the student with the given name.
	 * The student name must be given in the format: Lastname, Firstname.
	 * The student grades must be given separated by spaces: 100 100 
	 */
	private void setName()
	{
		Scanner keyboard = new Scanner(System.in);
		
		Pattern nameFormat = Pattern.compile("^[A-Za-z ]++,[A-Za-z ]++$"); // the pattern used to check that a comma separates the two names
	
		// prompts the user to enter the full name of a student
		System.out.println("\nPlease enter the student's full name in the format: Last Name, First Name");
		fullName = keyboard.nextLine();
		
		// checks for the proper format and will continue to prompt the user until it is correct
		while(!nameFormat.matcher(fullName).matches())
		{
			System.out.println("\nIncorrect name format.");
			System.out.println("\nPlease enter the student's full name in the format: Last Name, First Name");
			fullName = keyboard.nextLine();

		}
		
		String lastName = fullName.substring(0,fullName.indexOf(",")); //finds the last name and first name
		String firstName = fullName.substring(fullName.indexOf(",") +1);
		fullName = firstName.trim() + " " + lastName.trim(); // trims any extra spaces and reorganizes as FirstName LastName
		System.out.println("\nPlease enter the set of grades for "
				 + fullName + ":");
	}

	/**	The setGrades method calls the setup method of the Grades class to
	 *  that will prompt the user to enter the grades for the student.
	 */
	private void setGrades()
	{
		grades.setup();
	}
	
	/**The Display method prints the full name of the student and their grades to the console.
	 */
	public void display()
	{
		System.out.printf( "%-25s", fullName);
		grades.display();
	}

	/**	The overallGrade method returns (as a double) the overall grade(course average) of the student.
	 */
	public double overallGrade()
	{
		double averageGrade = grades.average();
		
		return averageGrade;	
	}		
}
