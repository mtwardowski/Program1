import java.text.SimpleDateFormat;
import java.util.Date;

/**
	@author	Michael Twardowski
	
	CSC 211								Program #1
						A   f i r s t   c l a s s   p r o g r a m
						=========================================
	
	Purpose:	To demonstrate the definition and the use of a simple class.
				The program "declares" three students, prompts the user to assign
				their names and grades, and determines the overall average grade between the students.

	Input:		The individual names and grades of the students.

	Output:		The individual grades and weighted course average for each student, and the overall
				class average.
*/

public class Program1
{
	public static void main(String[] args)
	{
		
		Student	firstStudent,					// The section of the class has 3 students
				secondStudent,
				thirdStudent;

		double theSectionAverage;				//	holds the section average
		
		String greeting;						// 	part of the greeting displayed to the client
		
		// Finds the current time (24 Hour clock) and formats it to display only the hour
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH"); 
        String currentHour = localDateFormat.format(new Date());       
        
        int hour = Integer.parseInt(currentHour);	// converts the String to an int					
        
        //Assigns the appropriate greeting based on the time of day
        if(hour < 12)
        {
        	greeting = "Morning";
        }else if (hour < 17)
        {
        	greeting = "Afternoon";
        }else // currentHour > 17
        {
        	greeting = "Evening";
        }
        
        System.out.println("Good " + greeting + "!");  // greets the client

		firstStudent = new Student();	//	"Creates" or "instantiates" the 3 students
		secondStudent = new Student();			
		thirdStudent = new Student();
		
		firstStudent.setup();			//	assigns names and grades for each student
		secondStudent.setup();
		thirdStudent.setup();
		
		// displays the full name and all grades for each student in formatted columns
		System.out.printf("%n%-25s%-18s%-15s%-14s%n","Student Name:","Program Grade:","Exam Grade:","Overall Grade:");
		
		firstStudent.display();
		secondStudent.display();
		thirdStudent.display();
		
		theSectionAverage = (firstStudent.overallGrade()	//	Computes the section average
							+ secondStudent.overallGrade()
							+ thirdStudent.overallGrade())/3;

		System.out.print("\nThe overall section average is: "); // displays the section average
		System.out.printf("%.2f%n", theSectionAverage);
		
		System.out.println("\nGoodbye!");
	}
}
