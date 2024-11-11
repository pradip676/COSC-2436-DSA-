//Pradip Sapkota
import java.util.*;
public class Homework2
{
    static long Counter = 0;
	public static void main(String[] args) {
	    
	    Scanner input = new Scanner(System.in);
        
	    //Program 1
	    System.out.println("~~~~~~~ Program 1 ~~~~~~~");
	    System.out.print("How many bunnies are in the line? ");
	    int numRabbits = input.nextInt();
		System.out.println("This is a total of " + bunnyEars(numRabbits) + " ears.");
		System.out.println();   //leave a blank line
		
		//Program 2
		System.out.println("~~~~~~~ Program 2 ~~~~~~~");
		System.out.println();
		System.out.print("Please enter an integer: ");
		int n = input.nextInt();
		System.out.println("The sum of these digits is " + sumDigits(n)+ ".");
		System.out.println();
		
		//Program 3
		System.out.println("~~~~~~~ Program 3 ~~~~~~~");
		System.out.println();
		input.nextLine();
		System.out.print("Please enter a string: ");
		String s = input.nextLine();
		System.out.println("Your string in reverse: " + revString(s));
		System.out.println();
		
		//Program 4
		System.out.println("~~~~~~~ Program 4 ~~~~~~~");
		System.out.println();
		System.out.print("Which Fibonacci number would you like to calculate? ");
		long fibNum = input.nextInt();
		System.out.println();
		long BeginTime = System.currentTimeMillis();
		System.out.println("This Fibonacci number = " + fib(fibNum));
		System.out.println("Number of method calls made = " + Counter);
		long EndTime = System.currentTimeMillis();
        System.out.println("Seconds used for this calculation = " + (EndTime - BeginTime)/1000.0);
		
	}
	static String revString(String str)
	{
	    if (str.length() == 1)     //base case stops recursion
	        return str;
	    return str.substring(str.length()-1) + revString(str.substring(0,str.length()-1));
	    
	}
	static int sumDigits(int num)
	{
	    if(num < 10)    //base case stops recursion
	        return num;
	    //sum rightmost digit (1's place) and add sum of remaining sumDigits
	    return num%10 + sumDigits(num/10);
 	}
	static int bunnyEars(int numRabbits)
	{
	    if(numRabbits == 1)  //base case recursion
	        return 3;
	    if(numRabbits%10==0)   //multiple of 10th rabbit have 4 ears
	        return 4 + bunnyEars(numRabbits-1); 
	    
	    if (numRabbits%5==0)    //multiple of 5th rabbit have 4 ears(but not 10th multiple)
	        return 1 + bunnyEars(numRabbits-1);
	    if(numRabbits%2==0)  //even numbers
	        return 2 + bunnyEars(numRabbits-1);
	    else                //odd numbered rabbits
	        return 3 + bunnyEars(numRabbits-1);
	}
	static long fib(long n)
    {
        Counter++;
        if (n == 0 || n ==1) // base cases for recursion
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}
