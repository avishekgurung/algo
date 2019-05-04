package practice;

import java.util.Arrays;
import java.util.Comparator;

class Node {
  int index;
  int value;
  Node(int value, int index) {
    this.value = value;
    this.index = index;
  }
}


class NodeComparator implements Comparator<Node> {
  public int compare(Node o1, Node o2) {
    if(o1.value > o2.value) return 1;
    else if(o1.value < o2.value) return -1;
    else {
      if(o1.index > o2.index) return 1;
      else return -1;
    }
  }
}

public class SortCompare {



  public static void main(String[] args) {
    Node[] nodes = new Node[4];
    nodes[0] = new Node(4,0);
    nodes[1] = new Node(4,1);
    nodes[2] = new Node(4,2);
    nodes[3] = new Node(4,3);

    Arrays.sort(nodes, new NodeComparator());

    for(Node node : nodes) {
      System.out.println(node.value + " " + node.index);
    }

  }



}
