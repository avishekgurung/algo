package online;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pricing {

  public static void finalPrice(List<Integer> prices) {
    int n = prices.size();
    int arr[] = new int[n];

    for(int i=0; i < prices.size(); i++) {
      arr[i] = prices.get(i);
    }

    int sum = arr[n-1];
    int smallest = arr[n-1];
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(n-1);
    for(int i=n-2; i >=0 ;i--) {
      if(arr[i] >= smallest) {
        sum = sum + (arr[i] - smallest);
      }
      else {
        smallest = arr[i];
        sum = sum + arr[i];
        stack.push(i);
      }
    }
    System.out.println(sum);
    while(!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }

  public static void main(String[] args) {
    List<Integer> l1 = new ArrayList<Integer>();
    l1.add(5);
    l1.add(1);
    l1.add(3);
    l1.add(3);
    l1.add(2);
    l1.add(5);
    finalPrice(l1);
  }
}
