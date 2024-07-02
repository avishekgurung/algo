package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem004 {

  public static int evaluateInfix(String infixExpression) {
    String[] infix = infixExpression.split(" ");
    Stack<String> operators = new Stack<String>();
    Stack<Integer> values = new Stack<Integer>();
    Map<String, Integer> priorityMap = new HashMap<String, Integer>();

    priorityMap.put("-", 0 );
    priorityMap.put("+", 1);
    priorityMap.put("*", 2);
    priorityMap.put("/", 3);

    for(int i=0; i < infix.length; i++) {
      String item = infix[i];

      if(item.equals("/") || item.equals("*") || item.equals("+") || item.equals("-")) {
        int itemPriority = priorityMap.get(item);

        while(!operators.isEmpty() && !operators.peek().equals("(") && priorityMap.get(operators.peek()) > itemPriority) {
          String operator = operators.pop();
          int y = values.pop();
          int x = values.pop();
          if(operator.equals("*")) values.push(x*y);
          if(operator.equals("/")) values.push(x/y);
          if(operator.equals("+")) values.push(x+y);
          if(operator.equals("-")) values.push(x-y);
        }
        operators.push(item);
      }
      else if(item.equals("(")) {
        operators.push(item);
      }
      else if(item.equals(")")) {
        while(!operators.isEmpty() && !operators.peek().equals("(")) {
          String operator = operators.pop();
          int y = values.pop();
          int x = values.pop();
          if(operator.equals("*")) values.push(x*y);
          if(operator.equals("/")) values.push(x/y);
          if(operator.equals("+")) values.push(x+y);
          if(operator.equals("-")) values.push(x-y);
        }
        operators.pop();
      }
      else {
        values.push(Integer.parseInt(item));
      }
    }

    while(!operators.isEmpty()) {
      String operator = operators.pop();
      int y = values.pop();
      int x = values.pop();
      if(operator.equals("*")) values.push(x*y);
      if(operator.equals("/")) values.push(x/y);
      if(operator.equals("+")) values.push(x+y);
      if(operator.equals("-")) values.push(x-y);
    }

    return values.pop();
  }

  public static void main(String[] args) {
    String infix = "2 * 3 + 4";
    System.out.println(infix + " : " + evaluateInfix(infix));

    infix = "2 + 3 * 3";
    System.out.println(infix + " : " + evaluateInfix(infix));

    infix = "( 2 + 3 ) * 3";
    System.out.println(infix + " : " + evaluateInfix(infix));

    infix = "2 + 5 * 20 / 4 - 5";
    System.out.println(infix + " : " + evaluateInfix(infix));

  }
}

/**
 * One naive approach could be first convert infix to postfix and then evaluate postfix.
 * But here, we do the above two approach at the same time.
 */
