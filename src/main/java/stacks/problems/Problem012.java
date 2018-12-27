package stacks.problems;

import java.util.Stack;

public class Problem012 {

  public static int findMaxAreaInHistogram(int[] histogram) {
    int maxArea = 0;
    int i = 0;
    Stack<Integer> stack = new Stack<Integer>();

    while(i < histogram.length) {
      if(stack.isEmpty() || histogram[i] >= histogram[stack.peek()]) {
        stack.push(i++);
      }
      else {
        int top = stack.pop();
        int width = stack.isEmpty() ? i : i - 1 - stack.peek();
        int topArea = width * histogram[top];
        if(topArea > maxArea) maxArea = topArea;
      }
    }

    while(!stack.isEmpty()) {
      int top = stack.pop();
      int width = stack.isEmpty() ? i : i - 1 - stack.peek();
      int topArea = width * histogram[top];
      if(topArea > maxArea) maxArea = topArea;
    }

    return maxArea;
  }


  public static void main(String[] args) {

    int[] histogram = new int[] {6, 5, 5, 4, 5, 1, 6};
    System.out.println(findMaxAreaInHistogram(histogram));

  }

}
