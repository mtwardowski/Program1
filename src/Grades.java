/**
	Grades.java
	
	@author	Michael Twardowski
	
	The Grades class defines grades for a student.
	The following operations are available for Grades:
	. 	setup(fullName) 	Prompts the client to input grades for student and initializes them.
	.	display()			Prints grades of the student to the console.
	.	average()			Returns (as a double) the overall grade(weighted course average) of the student.
*/

import java.util.Scanner;

public class Grades 
{
	
	/**	
	 *	To hold the individual grades for programming and exams
	 */						
	private double programGrade,
	 			   examGrade;

	/**	Prompts the client to input grades for student and initializes them.
	 * @Param requires the students full name.
	 */
	public void setup(String fullName)
	{
		Scanner keyboard = new Scanner(System.in);
	
		System.out.println("\nPlease, enter the program and exam grades seperated by spaces for "
							 + fullName + ":"); // prompts the client for grade input
		programGrade = keyboard.nextDouble();
		examGrade = keyboard.nextDouble();
	}
	
	/** Prints grades of the student to the console.
	 */
	public void display()
	{
		System.out.printf("%-18.2f%-15.2f%-14.2f%n",programGrade,examGrade,average()); // prints grades to console
	}
	
	/**Returns (as a double) the overall grade(course average) of the student
	 * The program grade has weight of 40%.
	 * The exam grade has a weight of 60%.
	 * @return the course average (as a double).
	 */
	public double average()
	{
		final double
		 PROGRAM_WEIGHT = 0.40,				//40% for the program,
		 EXAM_WEIGHT = 1 - PROGRAM_WEIGHT;	//and the rest for the exam

		//The student averageGrade is a simple weighted average
		double averageGrade = programGrade * PROGRAM_WEIGHT
					 + examGrade * EXAM_WEIGHT;

		return averageGrade;				//returns the student's average.
	}
}
