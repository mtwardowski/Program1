/**
	Student.java
	
	@author	Michael Twardowski
	
	The Student class defines a student as having a name and a set of grades.
	The following operations are available on a student:
	.	setName(someName)	Sets the name of the student to someName (a String)
	.	readGrades()		Reads the set of grades for the student
	.	overallGrade()		Returns (as a double) the overall grade of the student
*/

import java.util.Scanner;
import java.util.regex.Pattern;				//To be able to define a Keyboard

public class Student
{

	/**	
	 *	To hold the name of the student
	 */
	private	 String	fullName,
					firstName,
					LastName;
	
	/**	
	 *	To hold the individual grades
	 */						
	private	 int programGrade,
				 examGrade;	
	
	/**	The setup method initializes the name of the student with the given name and
	 *	PRECONDITION:	
	 *	POSTCONDITION:	
	 */
	public void setup()
	{
		setName();
		setGrades();
	}
	
	

	/**	The setName method initializes the name of the student with the given name.
	 *	PRECONDITION:	None.
	 *	POSTCONDITION:	The student's name is initialized.
	 */
	private void setName()
	{
		Scanner keyboard = new Scanner(System.in);
		
		Pattern nameFormat = Pattern.compile("^[A-Za-z ]++,[A-Za-z ]++$");
		
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
		
		String lastName = fullName.substring(0,fullName.indexOf(","));
		String firstName = fullName.substring(fullName.indexOf(",") +1);
		fullName = firstName.trim() + " " + lastName.trim(); // trims any extra spaces and reorganizes as FirstName LastName
		
		System.out.println(fullName);
		
	}

	/**	The readGrades method prompts the user and enters the grades for the student.
	 *	PRECONDITION:	The student is assumed to have already been given a name.
	 *	POSTCONDITION:	The student's individual grades are initialized from the keyboard.
	 */
	private void setGrades()
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("\nPlease, enter the program and exam grades for "
							+ fullName + ":");
		programGrade = keyboard.nextInt();
		examGrade = keyboard.nextInt();
		
	}

	/**	The overallGrade method determines (and returns) the student's average grade.
	 *	PRECONDITION:	The student has already been given individual grades.
	 *	POSTCONDITION:	The student's overall grade is returned.
	 */
	public double overallGrade()
	{
		final double
				 PROGRAM_WEIGHT = 0.40,				//40% for the program,
				 EXAM_WEIGHT = 1 - PROGRAM_WEIGHT;		//and the rest for the exam

		double theOverallGrade;
										//The student overall grade is
										//a simple weighted average
		theOverallGrade = programGrade * PROGRAM_WEIGHT
							+ examGrade * EXAM_WEIGHT;

		return theOverallGrade;						//We return the student average
	}

				
}
