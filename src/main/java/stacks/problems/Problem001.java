package stacks.problems;

import java.util.Stack;

public class Problem001 {

  private static boolean expressionValidator(String expression) {
    Stack<Character> stack = new Stack<Character>();
    boolean isExpValid = true;

    for(int i=0; i < expression.length(); i++) {
      char item = expression.charAt(i);
      if(item == '{' || item == '(' || item == '(') {
        stack.push(item);
      }

      if(item == '}' || item == ']' || item == ')') {
        if(stack.empty()) {
          isExpValid = false; break;
        }
        char poppedItem = stack.pop();

        if(item == '}' && poppedItem != '{') {
          isExpValid = false; break;
        }

        if(item == ']' && poppedItem != '[') {
          isExpValid = false; break;
        }

        if(item == ')' && poppedItem != '(') {
          isExpValid = false; break;
        }
      }
    }
    if(!stack.empty()) isExpValid = false;
    return isExpValid;
  }

  public static void main(String[] args) {

    String expression = "(a+b)";
    System.out.println(expression + ": " + expressionValidator(expression));

    expression = "(a+b))";
    System.out.println(expression + ": " + expressionValidator(expression));

    expression = "((a+b)";
    System.out.println(expression + ": " + expressionValidator(expression));

    expression = "(a+b)+(c+d)";
    System.out.println(expression + ": " + expressionValidator(expression));

    expression = "(a+b)+(c+d))";
    System.out.println(expression + ": " + expressionValidator(expression));

    expression = "[{(a+b)+(c+d)}+e]";
    System.out.println(expression + ": " + expressionValidator(expression));

    expression = "{a*(c+d}+e)";
    System.out.println(expression + ": " + expressionValidator(expression));
  }

}
