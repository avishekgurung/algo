package tree.binary.problems;

import java.util.HashMap;
import java.util.Map;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem028 {

  static int inorder[];
  static int postOrderIndex;
  static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

  public static Node createTree(int[] inorder, int[] postOrder) {
    postOrderIndex = 0;
    Problem028.inorder = inorder;

    for(int i=0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    postOrder = reverse(postOrder);
    Node root = create(postOrder, 0, postOrder.length-1);
    return root;
  }


  private static int[] reverse(int arr[]) {
    int temp[] = new int[arr.length];
    for(int i=0; i < arr.length; i++) {
      temp[arr.length-i-1] = arr[i];
    }
    return temp;
  }

  public static Node create(int[] postOrder, int left, int right) {
    int data = postOrder[postOrderIndex];
    postOrderIndex++;
    Node node = new Node(null, data, null);
    if(left >= right) {
      return node;
    }
    int inorderIndex = map.get(data);
    node.right = create(postOrder, left, inorderIndex-1);
    node.left = create(postOrder, inorderIndex + 1, right);
    return node;
  }

  public static void main(String[] args) {
    int[] inorder = new int[]   {4,2,5,1,6,3,7};
    int[] postorder = new int[] {4,5,2,6,7,3,1};
    /*int[] inorder = new int[] {2,1,3};
    int[] postorder = new int[]{2,3,1};*/
    Node root = createTree(inorder, postorder);
    BinaryTree.display(root);
  }

}

/**
 *
 */