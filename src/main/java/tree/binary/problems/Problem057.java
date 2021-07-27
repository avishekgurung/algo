package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem057 {
  /**
   * A simple approach is to create a tree from inorder and pre-order. And then make
   * postorder traversal of a tree.
   *
   * But rather than creating a tree, we can simply print post-order traversal using the
   * above two traversals and compare every print with given post-order array.
   *
   */


  private static int[] preorder = {1,2,4,5,3,6,7};
    private static int[] inorder = {4,2,5,1,6,3,7};
    private static int[] postorder = {4,5,2,6,7,3,0};

    private static int poi = 0;
    private static int pri = 0;
    private static int ioi = 0;

    private static int getInorderIndex(int element) {
        for(int i=0; i < inorder.length; i++) {
            if(element == inorder[i]) return i;
        }
        return -1;
    }

    private static boolean checkTree(int left, int right) {
        if(left > right) return true;
        int data = preorder[pri++];
        int inorderIndex = getInorderIndex(data);

        if(left==right) {
            if(data != postorder[poi++]) {
                return false;
            }
            return true;
        }
        boolean leftRes = checkTree(left, inorderIndex-1);
        boolean rightRes = checkTree(inorderIndex+1, right);

        if(data != postorder[poi++]) {
            return false;
        }
        return leftRes && rightRes;
    }

    public static void main(String[] args) {
        Node root = BinaryTree.createTree(new int[]{1,2,3,4,5,0,6});
        BinaryTree.display(root);
        System.out.println();
        System.out.println(checkTree(0, 6));
    }
}
