package stacks.problems;

import java.util.Arrays;
import java.util.Stack;

public class Problem021 {

  public static int nextGreateElements(int input[], int index) {
    int nge[] = new int[input.length];
    Stack<Integer> stack = new Stack<Integer>();

    for(int i=0; i < input.length; i++) {
      while(!stack.isEmpty() && input[stack.peek()] < input[i]) {
        int ind = stack.pop();
        nge[ind] = i;
      }
      stack.push(i);
    }

    int count = 0;
    while(nge[index] != 0) {
      count++;
      index = nge[index];
    }
    return count;
  }

  public static int nextGreaterElementsSimple(int[] input, int index) {
    int ele = input[index];
    int count = 0;

    for(int i=index+1; i < input.length; i++) {
      if(input[i] > ele) {
        count++;
        ele = input[i];
      }
    }
    return count;
  }


  public static void main(String[] args) {
    int[] input = new int[] {3, 4, 2, 7, 5, 8, 10, 6};
    int index = 0;
    int result = nextGreaterElementsSimple(input, index);
    System.out.println(Arrays.toString(input));
    System.out.println(input[index] + " : " + result);

    index = 1;
    result = nextGreaterElementsSimple(input, index);
    System.out.println(input[index] + " : " + result);

    index = 2;
    result = nextGreaterElementsSimple(input, index);
    System.out.println(input[index] + " : " + result);

    index = 3;
    result = nextGreaterElementsSimple(input, index);
    System.out.println(input[index] + " : " + result);

    index = 4;
    result = nextGreaterElementsSimple(input, index);
    System.out.println(input[index] + " : " + result);


    index = 5;
    result = nextGreaterElementsSimple(input, index);
    System.out.println(input[index] + " : " + result);

    index = 6;
    result = nextGreaterElementsSimple(input, index);
    System.out.println(input[index] + " : " + result);

    index = 7;
    result = nextGreaterElementsSimple(input, index);
    System.out.println(input[index] + " : " + result);
  }

  /**
   * This problem is also a tweak of Next greater element. For every element, we find the next
   * greater element, and store them in a separate array. We store the indices and not the actual
   * value of elements.
   *
   * For a given index, we check which is its next highest element.
   * Now for this next highest element, we check which is its next highest element.
   * We continue to do it and finally get the result.
   *
   * Sol 2: nextGreaterElementsSimple
   *  This is a very simple solution to the problem without using any stack.
   *
   *
   */

}
