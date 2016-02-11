import java.text.SimpleDateFormat;
import java.util.Date;

/**
	@author	Michael Twardowski
	
	CSC 211								Program #1
						A   f i r s t   c l a s s   p r o g r a m
						=========================================
	
	Purpose:	//To demonstrate the definition and the use of a simple class.
				The program "declares" a couple of students, prompts the user to assign
				grades, and determines the overall average grade between the two students.

	Input:		//The individual grades of the students.

	Output:		//The overall average grade between the two students.
*/

public class Program1
{
	public static void main(String[] args)
	{
		Student	first,								//	A very special section of CSC 211
				second,
				third;								//		is made up of only 3 students

		double theSectionAverage;					//	To determine the section average
		
		String greeting;							// 	Program greeting
		
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
        
        System.out.println("Good " + greeting + "!");

		first = new Student();						//	"Creates" or "instantiates"
		second = new Student();						//		our 3 students
		third = new Student();
		
		first.setup();			//	Assigns the names of the 2 students
		second.setup();
		third.setup();
		
		theSectionAverage = (first.overallGrade()	//	Computes the section average
							+ second.overallGrade()
							+ third.overallGrade())/3;

		System.out.println("\nThe overall section average is: " + theSectionAverage);
		System.out.println();
		System.out.println("Goodbye!");
	}
}
