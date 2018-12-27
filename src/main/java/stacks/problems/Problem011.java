package stacks.problems;

import java.util.Arrays;
import java.util.Stack;

public class Problem011 {

  public static int[] findSpan(int input[]) {

    int output[] = new int[input.length];
    Stack<Integer> stack = new Stack<Integer>();

    for(int i=input.length-1; i>=0; i--) {
      while (!stack.isEmpty() && input[i] >= input[stack.peek()]) {
        int index = stack.pop();
        output[index] = index - i;
      }
      stack.push(i);
    }
    output[0] = 1;
    return output;
  }

  public static void main(String[] args) {

    int[] input = new int[] {6,3,4,5,2};
    int[] output = findSpan(input);
    System.out.println(Arrays.toString(input));
    System.out.println(Arrays.toString(output));
    System.out.println();

    input = new int[] {100, 80, 60, 70, 60, 75, 85};
    output = findSpan(input);
    System.out.println(Arrays.toString(input));
    System.out.println(Arrays.toString(output));

  }

}

/**
 * The naive approach is to compare one element with every other element, which takes time as O(n2)
 * and space as O(1).
 *
 * This problem is tweak of 'Finding the next highest element'. This kind of problem usually occurs
 * in stock problems.
 *
 * We are just finding the next highest element to its left starting from the end of an array but
 * rather than storing the value in the stack, we are actually storing the index in a stack.
 *
 * The time and space complexity of this algo is O(n).
 *
 * Use of stack leads to space complexity as O(n).
 *
 * Time complexity is O(n) because the inner while loop for every iteration does not run for n times.
 * All in all, the popping of element takes place for only n times (and not for every iteration of
 * for loop). Meaning for every iteration, sometimes no element is popped, sometimes few elements are
 * popped, and when all the (for loop) iteration are completed, the while loop runs in total for
 * only n times hence the total time complexity is O(n).
 *
 **/
