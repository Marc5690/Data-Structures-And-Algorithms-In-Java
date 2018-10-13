package com.dsaa.stack;

import java.util.Scanner;

public class PostFixCalculator {

	public Stack<Integer> argumentsStack;
	
	public PostFixCalculator() {
		argumentsStack = new Stack<Integer>();
	}
	
	public Stack<Integer> runInputs(String[] arguments) {
		for(String value : arguments) {
			
		    //We need to check and see if each character is an operator or a number
			Scanner characterTypeCheck = new Scanner(value);
			
			//If it's an int, add it to the stack. If it's not, use the operator on the
			//top two numbers in the stack
			if(characterTypeCheck.hasNextInt()) {
				System.out.println("Int: " + value);
				Integer numberArgument = Integer.parseInt(value);
				argumentsStack.push(numberArgument);
			}
			else{
				System.out.println("Operation: " + value);
				Integer firstArg = argumentsStack.pop();
				Integer secondArg = argumentsStack.pop();
				try {
					argumentsStack.push(calculateOperation(value, firstArg, secondArg));
				} catch (Exception e) {
					//We're just going to catch errors here, although we could
					//also throw exceptions up to the caller as well.
					e.printStackTrace();
				}
			}
		}
		
		return argumentsStack;
	}
	
	public static void main(String args[]) {
		
		//These are just values to use as testing data. Feel free to
		//mix them up when you're trying out this Post-Fix calculator.
		String[] instructions = {"1","2","+"};
		String[] instructions2 = {"1","5", "3","-"};
		String[] instructions3 = {"1","2","3", "*", "-"};
		
		Stack<Integer> calc = new PostFixCalculator().runInputs(instructions2);
		
			while(calc.peek() != null) {
				System.out.println(calc.pop());
			}

		System.out.println("Done");
		
	}
	
	public Integer calculateOperation(String operator, Integer firstOperand, Integer secondOperand) throws Exception{
		
		Integer result = null;
		
	
			
		
		  switch(operator) {
    	  case "+":
    		  result = firstOperand + secondOperand;
    		  break;
    	  case "-":
    		  result = firstOperand - secondOperand;
    		  break;
    	  case "*":
    		  result = firstOperand * secondOperand;
    		  break;
    	  case "/":
    		  result = firstOperand / secondOperand;
    		  break;
    	  default:
    		  //If the character isn't a number and isn't an operation we support,
    		  //throw an exception.
    		  throw new Exception();	
		  }

		return result;
    }
		
	
}
