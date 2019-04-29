package eg.edu.alexu.csd.datastructure.stack.cs56;
import java.util.Scanner;


/**
 * this class represents a UI to test the implementation of the stack class
 * @author Mohamed saad
 *
 */
public class Main {
	public static void main(String[] args) 
	 { 
	     // create Object of Implementing class 
	     Stack1 obj = new Stack1(); 
	     
	     System.out.println("Please choose an action :");
	     System.out.println("-------------------------");
	     System.out.println("1: Push ");
	     System.out.println("2: Pop ");
	     System.out.println("3: Peek \n4: Get size \n5: Check if empty");
	     System.out.println("Enter -1 to end ");
	     
	     Scanner x =new Scanner (System.in);
	     int a =x.nextInt();
	     x.nextLine();
	     while (a!= -1) {
	    	 if (a==1) {
	    		 System.out.println("Enter the element you want to push : ");
	    		 String b =x.nextLine();
	    		 obj.push(b);
	    		 obj.display();
	    	 }
	    	 else if (a==2) {
	    		 System.out.println("poped : "+obj.pop());
	    	 }
	    	 else if (a==3) {
	    		 System.out.println("Top element is "+ obj.peek());
	    	 }
	    	 else if (a==4) {
	    		 System.out.println(obj.size());
	    	 }
	    	 else if (a==5) {
	    		 if (obj.isEmpty()) {
	    			 System.out.println("stack is empty"); 
	    		 }
	    		 else {
	    			 System.out.println("stack is not empty");
	    		 }
	    	 }
	    	 else {
	    		 System.out.println("please enter 1,2,3,4,5 or -1 to end");
	    	 }
	    	 System.out.println("\n Please choose an action :");
		     System.out.println("-------------------------");
		     System.out.println("1: Push ");
		     System.out.println("2: Pop ");
		     System.out.println("3: Peek \n4: Get size \n5: Check if empty");
		     System.out.println("Enter -1 to end ");
	    	 a =x.nextInt();
	    	 x.nextLine();
	     }

	 } 
}
