//Pradip Sapkota 
//This program contains only the part 1 of the homework 5 which is creating a linked list using the Node class
import java.util.*;
import java.io.*;
public class Homework5
{
	public static void main(String[] args) throws IOException {
	    Scanner infile = new Scanner(new File("primes1.txt"));
	    Node Head = new Node(infile.nextInt());   //make Head first file number
	    Node Temp;
        while(infile.hasNextInt())
        {
            //add a new node at beginning of list
            Temp = new Node(infile.nextInt());  //create new Node with next integer in file
            Temp.Next = Head;
	        Head = Temp;
        }
        infile.close();
        Scanner in = new Scanner(System.in);
        int Choice = 0;
        while (Choice !=4)
        {
            System.out.println("\n||||||||||||||| Main Menu |||||||||||||||");
            System.out.println("1 = Search for a Number");
            System.out.println("2 = Add a new Number");
            System.out.println("3 = Delete a Number");
            System.out.println("4 = Exit");
            System.out.print("Enter your choice: ");
            Choice = in.nextInt();
            
            if(Choice == 1) //search for a number
            {
                System.out.print("What number should I search for? ");
                int searchNumber = in.nextInt();
                Temp = Head;
                while(Temp != null)
                {
                    if(Temp.Data == searchNumber)
                    {
                        System.out.println("Found: " + searchNumber);
                        break;
                    }
                    Temp = Temp.Next;  //point to next
                }
                if (Temp == null) {
                    System.out.println(searchNumber + " was not found in the list.");
                }
            }
            
            if(Choice == 2) //add a new Number
            {
                System.out.print("What number should I add? ");
                int newNumber = in.nextInt();
                Temp = new Node(newNumber);  //create new Node with next integer in file
                Temp.Next = Head;
	            Head = Temp;
	            System.out.println(newNumber + " was added.");
            }
            
            if (Choice == 3) // delete number
            {
                // ask user to enter a number to Delete
                System.out.print("What number should I delete? ");
                int deleteNumber = in.nextInt();
            
                // deleting the head node
                if (Head != null && Head.Data == deleteNumber) 
                {
                    System.out.println(deleteNumber + " was deleted");
                    Head = Head.Next; 
                } else {
                    Temp = Head;
                    Node Previous = Head;
            
                    while (Temp != null) // traverse list
                    {
                        if (Temp.Data == deleteNumber) // found It
                        {
                            System.out.println(deleteNumber + " was deleted");
                            Previous.Next = Temp.Next; // Remove the node by updating Previous.Next
                            break;
                        }
                        Previous = Temp; // Previous points to previous Node
                        Temp = Temp.Next; // move Temp pointer
                    }
            
                    if (Temp == null) {
                        System.out.println(deleteNumber + " is not found in the list.");
                    }
                }
            }

	    }
    }
}

class Node
{
    int Data;
    Node Next;  //pointer to Next
    
    Node (int theData)
    { Data = theData; }
}
