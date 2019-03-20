package array.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem049 {

  public void kMaxSumFromTwoArrays(int arr[], int brr[], int k) {
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(brr));
    Arrays.sort(arr);
    Arrays.sort(brr);

    int i= arr.length - 1;
    int j = brr.length - 1;

    PriorityQueue<Node> heap = new PriorityQueue<Node>(arr.length,new NodeComparator());
    Node node = new Node(arr[i] + brr[j], i, j);
    heap.add(node);

    System.out.println("The " + k + " maximum combinations are: ");
    while(!heap.isEmpty() && k !=0) {
      node = heap.remove();
      i = node.i;
      j = node.j;
      heap.add(new Node(arr[i-1] + brr[j], i - 1, j));
      heap.add(new Node(arr[i] + brr[j-1], i, j - 1));
      System.out.println(node.sum);
      k--;
    }
    System.out.println();
  }

  private class Node {
    int sum;
    int i;
    int j;
    Node(int sum, int i, int j) {
      this.sum = sum;
      this.i = i;
      this.j = j;
    }
  }

  private class NodeComparator implements Comparator<Node> {
    public int compare(Node o1, Node o2) {
      if(o1.sum > o2.sum) return -1;
      return 1;
    }
  }

  public static void main(String[] args) {
    Problem049 obj = new Problem049();
    obj.kMaxSumFromTwoArrays(new int[]{4,2,5,1},new int[]{8,0,3,5}, 3);
  }

}
