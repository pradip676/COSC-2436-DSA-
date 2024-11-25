//Pradip Sapkota
////This program contains the part 2 of the homework 5 which is creating binary search tree (BST)
import java.util.*;
import java.io.*;
public class BST
{
    static int currentDepth, maxDepth, sumDepths;
	public static void main(String[] args) throws IOException {
	    Scanner infile = new Scanner(new File("primes1.txt"));
	    Node Root = new Node(infile.nextInt());   //make Root first file number
	    int N=1;  //data set size
	    Node Temp;
        while(infile.hasNextInt())
        {
            currentDepth = 1;
            Insert(Root, infile.nextInt()); //create new node with next integer in file
            if(currentDepth > maxDepth)
                maxDepth = currentDepth;
            sumDepths += currentDepth;      
            N++;
 
        }
        infile.close();
        System.out.println("Creating Binary Tree from " + N + " prime numbers...");
        System.out.println("The maximum depth of the tree is " + maxDepth);
        System.out.println("The average depth of the tree is " + (double) sumDepths / N);
        
        Scanner in = new Scanner(System.in);
        int Choice = 0;
        while (Choice !=3)
        {
            System.out.println("\n||||||||||||||| BST Main Menu |||||||||||||||");
            System.out.println("1 = Search for a Number");
            System.out.println("2 = Add a new Number");
            System.out.println("3 = Exit");
            System.out.print("Enter your choice: ");
            Choice = in.nextInt();
            
            if(Choice == 1) //locate Number
            {
                System.out.print("What prime number should I search for? ");
                int search = in.nextInt();
                currentDepth = 1;
                if(Locate(Root, search))
                    System.out.println("Found at depth: " + currentDepth);
                else
                {
                    System.out.println("Your number was not found.");
                    int lessThan = search - 1;
                    int greaterThan = search + 1;
                    
                    while (!Locate(Root, lessThan))
                    {
                        lessThan--;
                    }
                    while (!Locate(Root, greaterThan))
                    {
                        greaterThan++;
                    }
                    System.out.println("The nearest prime number less than your number is " + lessThan);
                    System.out.println("The nearest prime number greater than your number is " + greaterThan);
                }
                    

            }
            if (Choice == 2) // add a new Number
            { 
                System.out.print("What number should I add? ");
                int newNumber = in.nextInt();
                if (isPrime(newNumber)) {
                    currentDepth = 1;
                    Insert(Root, newNumber);
                    System.out.println(newNumber + " is added.");
                } else {
                    System.out.println(newNumber + " is not a prime number and can not be added.");
                }
            }
        }
	} //end Main
	
	static void Insert(Node TheNode, int NewData)
    {
        currentDepth++;   //Increament every recursion
        if (TheNode.Data > NewData && TheNode.Left == null) // Left is null - add new node on left
        {
            Node T = new Node(NewData);
            T.Data = NewData;
            TheNode.Left = T;
         }
         else if (TheNode.Data < NewData && TheNode.Right == null) // Right is null - add new node on right
        {
            Node T = new Node(NewData);
            T.Data = NewData;
            TheNode.Right = T;
        }
        else if (TheNode.Data > NewData && TheNode.Left != null) // Left isn't null - recurse to left
            Insert(TheNode.Left, NewData);
        else if (TheNode.Data < NewData && TheNode.Right != null) // Right isn't null - recurse to right
            Insert(TheNode.Right, NewData);
        } //end Insert
    
    static boolean Locate(Node TheNode, int TheData)
    {
       if (TheNode == null)
          return false;
       if (TheNode.Data == TheData)
          return true;
       else if (TheNode.Data > TheData) // traverse tree to the left
          return Locate(TheNode.Left,TheData);
       else if (TheNode.Data < TheData) // traverse tree to the right
          return Locate(TheNode.Right,TheData);
       else if (TheNode.Data > TheData && TheNode.Left == null)
          return false;
       else if (TheNode.Data < TheData && TheNode.Right == null)
          return false;
       return false; // Java needs a default return
    }  //end Locate
    
    static boolean isPrime(int num) //check whether its prime number or not
    {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            if (num % i == 0) 
                return false;
        }
        return true;
    }
}

class Node
{
    int Data;
    Node Left, Right;  //pointers to Left and Right 
    
    Node (int theData)
    { Data = theData; }
}
