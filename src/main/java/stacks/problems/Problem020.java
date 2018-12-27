package stacks.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem020 {

  public static int[] nextGreaterFreq(int[] input) {
    int[] freq = new int[input.length];
    int[] output = new int[input.length];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for(int i=0; i < input.length; i++) {
      int f = 0;
      if(map.get(input[i]) != null) {
        f = map.get(input[i]);
      }
      map.put(input[i], ++f);

    }

    for(int i=0; i < input.length; i++) {
      freq[i] = map.get(input[i]);
    }

    Stack<Integer> stack = new Stack<Integer>();

    for(int i=0; i < freq.length; i++) {
      while (!stack.isEmpty() && freq[stack.peek()] < freq[i]) {
        int index = stack.pop();
        output[index] = input[i];
      }
      stack.push(i);
    }

    while(!stack.isEmpty()) {
      output[stack.pop()] = -1;
    }
    return output;
  }

  public static void main(String[] args) {
    int in[] = new int[] {1, 1, 2, 3, 4, 2, 1};
    int out[] = nextGreaterFreq(in);
    System.out.println(Arrays.toString(in));
    System.out.println(Arrays.toString(out));

    System.out.println();
    in = new int[] {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
    out = nextGreaterFreq(in);
    System.out.println(Arrays.toString(in));
    System.out.println(Arrays.toString(out));
  }
}

/**
 * This problem is just a tweak of Find the next greater element.
 **/
