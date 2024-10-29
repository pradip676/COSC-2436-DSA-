import java.util.*;
public class Homework1
{
	public static void main(String[] args) {
	    
	    Scanner input = new Scanner(System.in);
	    System.out.println("~~~~~~~ Program 1 ~~~~~~~");
	    System.out.println();  //Leave the blankline 
	    
	    System.out.print("Please enter an integer: ");
	    int Num = input.nextInt();
	    int N1=0,N2=0,N3=0,N4=0;
	    
	    while(N1 + N2 + N3 + N4 != Num)
	    {
	       N1 =(int) (Math.random() * Num) + 1;
	       N2 =(int) (Math.random() * Num) + 1;  
	       N3 =(int) (Math.random() * Num) + 1;  
	       N4 =(int) (Math.random() * Num) + 1;  
	    }
	    System.out.println("These numbers sum up to " + Num + ": " + N1 + ", " + N2 + ", " + N3 + ", " + N4);
	    System.out.println();
	    System.out.println("~~~~~~~ Program 2 ~~~~~~~");
	    System.out.println();
	    
	    System.out.println("3,1,5 = " + SameDifferent(3,1,5));
		System.out.println("2,0,2 = " + SameDifferent(2,0,2));
		System.out.println("5,5,5 = " + SameDifferent(5,5,5));
		System.out.println("8,9,2,4 = " + SameDifferent(8,9,2,4));
		System.out.println("7,7,1,7 = " + SameDifferent(7,7,1,7));
		System.out.println("4,4,4,4 = " + SameDifferent(4,4,4,4));
		
		
	    System.out.println("\n~~~~~~~ Program 3 ~~~~~~~");
	    System.out.println();  //leave a blanlkline
	    ArrayList<Student> Students = new ArrayList<Student>();
	    Students.add(new Student("Gonzalez", "Juan", 19, 3.8));
        Students.add(new Student("Brown", "Leanne", 20, 3.4));
        Students.add(new Student("Kumar", "Raj", 20, 3.5));
        Students.add(new Student("Tucker", "Alexa", 21, 3.9));
        // step through ArrayList and output data
        int SumAges = 0;
        for (int i=0; i<Students.size();i++)
        {
            System.out.println(Students.get(i).LastName + ", " + Students.get(i).FirstName +
                                "\t Age: " + Students.get(i).Age + " GPA: "+ Students.get(i).GPA + 
                                " " + Students.get(i).comment());
            SumAges += Students.get(i).Age;                    
                                
        }
        System.out.println("Average age = " + ((double)Students.get(0).SumAges/Students.size()));
        System.out.println("Average GPA = " + (Students.get(0).SumGPA/Students.size()));
	}   //end Main()
	
	static String SameDifferent( int A, int B, int C)
	{
	    if(A==B && B==C)
	        return "same";
	    else if (A==B || A==C || B==C)  
	        return "similar";
	    else 
	        return "different";
	}
	static String SameDifferent( int A, int B, int C, int D)
	{
	    if(A==B && B==C && C==D)
	        return "same";
	    else if ((A == B && B == C) || (A == B && B == D) || (A == C && C == D) || (B == C && C == D))  
	        return "similar";
	    else 
	        return "different";
	}
}

class Student
{
    String LastName, FirstName;
    int Age;
    double GPA;
    static int SumAges = 0;    //shared variables
    static double SumGPA = 0;
    Student(String theLname,String theFname, int theAge, double theGPA)  //constructor
    {
        LastName = theLname; FirstName = theFname; Age = theAge; GPA = theGPA;
        SumAges += Age;
        SumGPA += GPA;
    }
    
    String comment()
    {
        if(GPA>4)
            return "Hacler! Your GPA can't be over 4!";
        else if (GPA >3.5)
            return "Awesome student!";
        else
            return "Average Student!";
    }
}