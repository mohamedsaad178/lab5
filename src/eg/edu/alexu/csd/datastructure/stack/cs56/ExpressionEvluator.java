package eg.edu.alexu.csd.datastructure.stack.cs56;

/**
 * this class implements the IepressionEvaluator interface to convert an infix expression
 * to postfix expression and then evaluate it
 * @author mohamed saad
 *
 */

public class ExpressionEvluator implements IExpressionEvaluator {
	 String[] arr;
	 int arrcount=0;
	
	 /** 
	 * 
	 * Takes a symbolic/numeric infix expression as input and converts it to 
	 * postfix notation. There is no assumption on spaces between terms or the 
	 * length of the term (e.g., two digits symbolic or numeric term) 
	 * @param expression * infix expression 
	 * @return postfix expression 
	 */ 
	public String infixToPostfix(String expression) {
		for(int i=0;i<expression.length();i++) {
			char character = expression.charAt(i);
			char c=expression.charAt(0);
			if (!Character.isDigit(character)&&character!='+'&&character!='-'&&character!='*'&&character!='/'&&character!='('&&character!=')'&&character!=' ') {
				System.out.println("the expression must include only digits or +,-,* or / and start with a digit");
				return null;
			}
			if (!Character.isDigit(c)){
				System.out.println("the expression must include only digits or +,-,* or / and start with a digit");
				return null;
			}
		}
		
		Stack1 op=new Stack1();
		arr=new String[expression.length()];
		int j=0;
		while (j<expression.length()) {
			String t="";
			char cc=expression.charAt(j);
			while (Character.isDigit(cc)&&j<expression.length()) {
				t +=cc;
				j++;
				if (j<expression.length()) {
					cc=expression.charAt(j);
				}
			}
			if (!t.equals("")) {
			arr[arrcount]=t;
			arrcount++;
			}
			//
			if(j<expression.length()) {
			if (expression.charAt(j)=='(') {
				op.push(expression.charAt(j));
			}
			//
			if (expression.charAt(j)==')') {
				while (!String.valueOf(op.peek()).equals("(")) {
					String u1="";
					u1 +=op.pop();
					arr[arrcount]=u1;
					arrcount++;
				}
				op.pop();
			}
			//    
			if (expression.charAt(j)=='+'||expression.charAt(j)=='-') {
				if(op.isEmpty()||String.valueOf(op.peek()).equals("(")) {
					op.push(expression.charAt(j));
				}
				else {
					while (!op.isEmpty()&& !String.valueOf(op.peek()).equals("(")) {
						String o="";
						o +=op.pop();
						arr[arrcount]=o;
						arrcount++;
					}
					op.push(expression.charAt(j));
				}
			}
			//  
			if (expression.charAt(j)=='*'||expression.charAt(j)=='/') {
				//String s2=String.valueOf(op.peek());
				//System.out.println(String.valueOf(op.peek()));
				//if (s2.equals("+")) {
					//System.out.println("fine");
				//}
				if(op.isEmpty()||String.valueOf(op.peek()).equals("(")||String.valueOf(op.peek()).equals("+")||String.valueOf(op.peek()).equals("-")) {
					op.push(expression.charAt(j));
				}
				else {
					while (!op.isEmpty()&& !String.valueOf(op.peek()).equals("(")&& !String.valueOf(op.peek()).equals("+")&& !String.valueOf(op.peek()).equals("-")) {
						String u2="";
						u2 +=op.pop();
						arr[arrcount]=u2;
						arrcount++;
					}
					op.push(expression.charAt(j));
				}
				
			}
			}
			j++;
		}
		while(!op.isEmpty()) {
			String u3="";
			u3 +=op.pop();
			arr[arrcount]=u3;
			arrcount++;
		}
		String post ="";
		for (int i=0;i<arrcount;i++) {
			post +=arr[i];
			post +=' ';
		}
		return post;
	}
			
	/**
	 *  Evaluate a postfix numeric expression, with a single space separator 
	 * @param expression
	 *  postfix expression 
	 * @return the expression evaluated value 
	 */
	public int evaluate(String expression) {
		Stack1 ope = new Stack1();
		int j=0;
		String[] ar=new String [expression.length()];
		int counter =0;
		while (j<expression.length()) {
			String t="";
			while (expression.charAt(j)!=' '&&j<expression.length()) {
				t+=expression.charAt(j);
				j++;
			}
			ar[counter]=t;
			counter++;
			j++;
		}
		for (int i=0;i<counter;i++) {
			if (!ar[i].equals("+")&&!ar[i].equals("-")&&!ar[i].equals("*")&&!ar[i].equals("/")) {
				ope.push(Integer.parseInt(ar[i]));
			}
			if (ar[i].equals("+")) {
				int s1=(int)ope.pop() ; 
				int s2=(int)ope.pop() ;
				int s3=s1+s2;
				ope.push(s3);
			}
			if (ar[i].equals("-")) {
				int s1=(int)ope.pop() ; 
				int s2=(int)ope.pop() ;
				int s3=s2-s1;
				ope.push(s3);
			}
			if (ar[i].equals("*")) {
				int s1=(int)ope.pop() ; 
				int s2=(int)ope.pop() ;
				int s3=s1*s2;
				ope.push(s3);
			}
			if (ar[i].equals("/")) {
				int s1=(int)ope.pop() ; 
				int s2=(int)ope.pop() ;
				int s3=s2/s1;
				ope.push(s3);
			}
		}
		return (int)ope.pop();
	}
}
