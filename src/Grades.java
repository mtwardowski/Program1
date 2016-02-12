import java.util.Scanner;


public class Grades 
{
	
	/**	
	 *	To hold the individual grades
	 */						
	private double programGrade,
	 			   examGrade;
	
	private double averageGrade;

	public void setup(String fullName)
	{
		Scanner keyboard = new Scanner(System.in);
	
		System.out.println("\nPlease, enter the program and exam grades seperated by spaces for "
							 + fullName + ":");
		programGrade = keyboard.nextDouble();
		examGrade = keyboard.nextDouble();
	}
	
	public void display()
	{
		System.out.printf("%-14.2f    %-11.2f%n",programGrade,examGrade);
	}
	
	public double average()
	{
		final double
		 PROGRAM_WEIGHT = 0.40,				//40% for the program,
		 EXAM_WEIGHT = 1 - PROGRAM_WEIGHT;	//and the rest for the exam

		//The student averageGrade is a simple weighted average
		averageGrade = programGrade * PROGRAM_WEIGHT
					 + examGrade * EXAM_WEIGHT;

		return averageGrade;				//returns the student's average.
	}
}
