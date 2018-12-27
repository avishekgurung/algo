package stacks.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem002 {

  public static String infixToPostfix(String infix) {
    String postfix = "";
    Map<Character, Integer> priorityMap = new HashMap<Character, Integer>();
    priorityMap.put('-', 0 );
    priorityMap.put('+', 1);
    priorityMap.put('*', 2);
    priorityMap.put('/', 3);

    Stack<Character> stack = new Stack<Character>();

    for(int i=0; i < infix.length(); i++) {
      char item = infix.charAt(i);

      if(item == '/' || item == '*' || item == '+' || item == '-') {
        int itemPriority = priorityMap.get(item);
        while(!stack.isEmpty() && stack.peek() != '(' && itemPriority <= priorityMap.get(stack.peek())) {
          postfix = postfix + stack.pop();
        }
        stack.push(item);
      }
      else if(item == '(') {
        stack.push(item);
      }
      else if(item == ')') {
        while(!stack.isEmpty() && stack.peek() != '(') {
          postfix = postfix + stack.pop();
        }
        stack.pop(); // We want to remove '(' from the stack as well.
        postfix = postfix + item;
      }
    }

    while(!stack.isEmpty()) {
      postfix = postfix + stack.pop();
    }
    return postfix;
  }

  public static void main(String[] args) {
    String infix = "a+b";
    System.out.println(infix + " : " + infixToPostfix(infix));

    infix = "a+b+c";
    System.out.println(infix + " : " + infixToPostfix(infix));

    infix = "a+b-c";
    System.out.println(infix + " : " + infixToPostfix(infix));

    infix = "a*b+c-d/e";
    System.out.println(infix + " : " + infixToPostfix(infix));

    infix = "a*b+c-d/e*(f+g)";
    System.out.println(infix + " : " + infixToPostfix(infix));

    infix = "(a+b)*(c-d)";
    System.out.println(infix + " : " + infixToPostfix(infix));
  }
}

/**
 Logic:

 Give priority to arithmetic operators and store them in a map. Give priority based in BODMAS.

 Traverse an infix expression:
  1. If the character is +,-,* or /
      Compare its priority with the item in the stack. If the stack has higher(or equal) priority
      then pop it and add it to the result

      Push the item in the stack.

  2. If the character is '(', push it in stack

  3. If the character is ')', pop the elements from stack until '(' is reached and attach them to
      result.

  4. If the elements are numbers, simply add them to the result.

 **/
