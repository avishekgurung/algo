package stacks.problems;

import java.util.Stack;

public class Problem003 {

  public static int evaluatePostfix(String exp) {

    Stack<Integer> stack = new Stack<Integer>();
    String[] postfix = exp.split(" ");

    for(int i=0; i < postfix.length; i++) {
      String item = postfix[i];
      if(item.equals("*") || item.equals("/") || item.equals("-") || item.equals("+")) {
        int y = stack.pop();
        int x = stack.pop();
        if(item.equals("*")) stack.push(x*y);
        if(item.equals("/")) stack.push(x/y);
        if(item.equals("+")) stack.push(x+y);
        if(item.equals("-")) stack.push(x-y);
      }
      else {
        stack.push(Integer.parseInt(item));
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    String postfix = "5 4 + 2 -";
    System.out.println(postfix + " : " + evaluatePostfix(postfix));

    postfix = "3 5 * 10 5 - /";
    System.out.println(postfix + " : " + evaluatePostfix(postfix));

  }

}
