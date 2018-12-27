package stacks.problems;

/**
 * Look into the book for solution.
 */
public class Problem010 {

  private class Stack {
    String arr[];
    int base[];
    int top[];
    int n; //number of stacks

    Stack(int n, int arraySize) {
      this.n = n;
      arr = new String[arraySize];
      base = new int[n];
      top = new int[n];

      int sum = 0;
      int quo = arraySize/n;

      for(int i=0; i < base.length; i++) {
        base[0] = sum;
        top[0] = sum;
        sum = sum + quo;
      }
    }

    public void push(int stackId, String data) {
      int topOfCurrentStack = top[stackId];
      int baseOfNextStack = base[stackId+1];
      if(topOfCurrentStack + 1 == baseOfNextStack) {

      }
      else {
        arr[topOfCurrentStack+1] = data;
      }
    }

    public void rearrangeToRight(int index) {

    }

  }


}
