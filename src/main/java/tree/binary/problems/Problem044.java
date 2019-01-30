package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem044 {

  public static Node create(int pre[], int mirPre[]) {
    int post[] = new int[mirPre.length];
    for(int i=0; i < mirPre.length; i++) {
      post[mirPre.length-1-i] = mirPre[i];
    }
    Node node = Problem043.createUtil(pre, post);
    return node;
  }

  public static void main(String[] args) {
    int[] pre = new int[]{1,2,4,8,9,5,10,11,3,6,12,13,7,14,15};
    int[] mirPre = new int[]{1,3,7,15,14,6,13,12,2,5,11,10,4,9,8};
    Node node = create(pre, mirPre);
    BinaryTree.display(node);
  }
}
