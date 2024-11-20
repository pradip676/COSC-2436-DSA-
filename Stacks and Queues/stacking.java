//Pradip Sapkota
import java.util.*;
public class stacking
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    String s = " ";
	    while(s.length() > 0)
	    {
	        System.out.println("This program checks if the parentheses, brackets, and braces are balanced.");
	        System.out.print("Please enter a string: ");
	        s = input.nextLine();
	        if(balanced(s))
	            System.out.println("This string is balanced.");
	        else
	            System.out.println("This string is not balanced.");
	        System.out.println();     
	    }
	    
	    String Equation = " ";
	    while(true)
	    {
	        System.out.print("Enter an equation to solve: ");
	        Equation = input.nextLine();
	        if (Equation.length() == 0)
	            break;
	        System.out.println("Solution: " + solveEquation(Equation));
	        System.out.println();
	    }
		
	}
	static boolean balanced(String s)
	{
	    Stack<Character> myStack = new Stack<Character>();
	    for (int i=0; i<s.length(); i++)  //step through every character of s
	    {
	        if(s.charAt(i)== '(' || s.charAt(i)== '{' || s.charAt(i)== '[')
	            myStack.push(s.charAt(i));
	        else if ((s.charAt(i)== ')' || s.charAt(i)== '}' || s.charAt(i)== ']') && myStack.isEmpty())
	            return false;
	        else if (s.charAt(i)== ')')  
	        {
	            char Temp = myStack.pop();
	            if(Temp != '(')
	                return false;
	        }
	        else if (s.charAt(i)== '}')  
	        {
	            char Temp = myStack.pop();
	            if(Temp != '{')
	                return false;
	        }
	        else if (s.charAt(i)== ']')  
	        {
	            char Temp = myStack.pop();
	            if(Temp != '[')
	                return false;
	        }
	            
	    }
	    if(myStack.isEmpty())
	        return true;
	    else
	        return false;
	}
	static int solveEquation(String Equation)
	{
	    Stack<Integer> valueStack = new Stack<Integer>();
	    Stack<Character> operatorStack = new Stack<Character>();
	    for(int i=0; i<Equation.length();i++)
	    {
	        if (Equation.charAt(i) >= '0' && Equation.charAt(i) <= '9')
	            valueStack.push(Integer.parseInt(Equation.substring(i,i+1)));
	        else if (Equation.charAt(i) == '(' || (Equation.charAt(i) == '*' || Equation.charAt(i) == '/' || Equation.charAt(i) == '+' || Equation.charAt(i) == '-'))
	            operatorStack.push(Equation.charAt(i));
	        else if(Equation.charAt(i) == ')')
	        {
	            char op = operatorStack.pop();
	            int val2 = valueStack.pop();
	            int val1 = valueStack.pop();
	            
	            if (op == '*')
	                valueStack.push(val1 * val2);
	            if (op == '/')
	                valueStack.push(val1 / val2);
	            if (op == '+')
	                valueStack.push(val1 + val2);
	            if (op == '-')
	                valueStack.push(val1 - val2);
	                
	            operatorStack.pop();
	        }
	            
	    }
	    while(!operatorStack.isEmpty())
	    {  
	        char op = operatorStack.pop();
	        int val2 = valueStack.pop();
	        int val1 = valueStack.pop();
	        
	        if (op == '*')
	                valueStack.push(val1 * val2);
	        if (op == '/')
	            valueStack.push(val1 / val2);
	        if (op == '+')
	            valueStack.push(val1 + val2);
	        if (op == '-')
	            valueStack.push(val1 - val2);
	    }
	    return valueStack.pop();
	}
}
