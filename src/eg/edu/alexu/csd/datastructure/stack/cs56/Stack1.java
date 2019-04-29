package eg.edu.alexu.csd.datastructure.stack.cs56;

public class Stack1 implements IStack{
	private class Node { 
        Object data; // integer data 
        Node link; // reference variable Node type 
    } 
	
	int count=0;
	// create global top reference variable 
    Node top; 
    
    // Constructor 
    Stack1() 
    { 
        this.top = null; 
    } 
	
    // pop method 
	public Object pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("Stack is empty"); 
            return null;
		}
		else {
			count--;
			Object x =top.data;
			top=top.link;
			return x;
		}
	}

	// peek method
	public Object peek() {
		// TODO Auto-generated method stub
		if (!isEmpty()) { 
            return top.data; 
        } 
		else {
			 System.out.println("Stack is empty"); 
	            return null;
		}
	}

	// push method
	public void push(Object element) {
		Node temp = new Node();
		if (temp == null) {
			System.out.println("Heap Overflow");
			return;
		}
		count++;
		temp.data = element;
		temp.link= top;
		top =temp ;
	}


	// is empty method 
	public boolean isEmpty() {
		return top==null;
	}

	// size method 
	public int size() {
		return count;
	}
	
	
	//
	public void display() 
    { 
        // check for stack underflow 
        if (top == null) { 
            System.out.println("Stack Underflow"); 
            return; 
        } 
        else { 
            Node temp = top; 
            while (temp != null) { 
  
                // print node data 
                System.out.print(temp.data +" -->"); 
  
                // assign temp link to temp 
                temp = temp.link; 
            } 
        } 
    } 

}
