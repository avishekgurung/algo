package tree.binary.problems;


import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem029 {

  public static Node createTree(int[] levelOrder, int[] inOrder, int left, int right) {
    if(left > right) return null;
    if(left >= right) return new Node(null, levelOrder[0], null);

    int data = levelOrder[0];
    int inorderIndex = findIndex(inOrder, data);

    int[] leftLevel = createLevel(inOrder, levelOrder, left, inorderIndex-1);
    int[] rightLevel = createLevel(inOrder, levelOrder, inorderIndex+1, right);

    Node node = new Node(null, data, null);
    node.left = createTree(leftLevel, inOrder, left, inorderIndex-1);
    node.right = createTree(rightLevel, inOrder, inorderIndex+1, right);
    return node;
  }

  private static int[] createLevel(int inorder[], int[] levelOrder, int left, int right) {
    int[] newLevel = new int[right - left + 1];
    int x = 0;
    for(int i=0; i < levelOrder.length; i++) {
      for(int j=left; j <= right; j++) {
        if(levelOrder[i] == inorder[j]) {
          newLevel[x] = levelOrder[i];
          x++;
        }
      }
    }
    return newLevel;
  }

  private static int findIndex(int arr[], int ele) {
    for(int i=0; i < arr.length; i++) {
      if(arr[i] == ele) return i;
    }
    return -1;
  }


  public static Node levelOrderCreation(int[] levelOrder) {
    int n = levelOrder.length;
    Node[] list = new Node[n];
    for(int i=0; i < n; i++) {
      list[i] = new Node(null, levelOrder[i], null);
    }

    int i = 0, j = 1;
    while (j < n) {
      list[i].left = list[j];
      j++;
      if(j < n) {
        list[i].right = list[j];
        j++;
      }
      i++;
    }
    return list[0];
  }

  public static void main(String[] args) {
    int[] inOrder = new int[]{4,2,5,1,6,3,7};
    int[] levelOrder = new int[]{1,2,3,4,5,6,7};
    Node node = createTree(levelOrder, inOrder, 0, levelOrder.length-1);
    BinaryTree.display(node);

    //Simple way
    System.out.println();
    node = levelOrderCreation(levelOrder);
    BinaryTree.display(node);
  }
}

/**
 *
 * This is not like some normal tree creation.
 * Explaining the detail here.
 *
 * Let levelOrder = 5,4,7,3,2,1,6 and Inorder = 3,4,2,5,1,7,6
 *
 * The tree that should be generated is
 *
 *       |------5 ----|
 *    |--4--|    |---7--|
 *   3     2     1      6
 *
 *
 *   The 1st element of level order is always a root. Here its 5. Now in inorder,
 *   the elements to right of 5 is a left subtree and to its right is the right
 *   subtree. Hence, 3,4,2 is the left subtree and 1,7,6 is the right subtree.
 *
 *   We must note that we cannot make a similar approach as we use to create tree
 *   from preorder and inorder traversals. We cannot start creating a node by
 *   incrementing the index of level order list.
 *
 *   So the idea is to create a new level order left and right array. So 3,4,2 will
 *   be the left substree but before that we have to order them in the fashion how
 *   it appears in the level order list. Meaning, we need to create a new array
 *   which will be 4,3,2. Because this is the order in level order list and also
 *   considering the above left tree, we see that level order traversal gives 4,3 and 2.
 *
 *   Likewise we create a right level order elements.
 *
 *   Hence, in the next recursion we will be using this array in place of level
 *   order array.
 *
 *  https://algorithms.tutorialhorizon.com/construct-a-binary-tree-from-given-inorder-and-level-order-traversal/
 *
 *  Approach 2.
 *  We can simply create a tree from level order without even using inorder. Just
 *  create two queue and add all the nodes. Pop one from q1 (x) and pop two from q2(a,b)
 *  x.left = a, x.right = b. Continue till q2 is exhausted.
 *
 *
 */
