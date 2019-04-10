package tree.binary.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem045 {

  public static Node createTree(int arr[][]) {

    Queue<Node> queue = new LinkedList();
    int max = 0;
    int data = 0;
    int len = arr[0].length;

    for(int i=0; i < len; i++) {
      int count = 0;
      for(int j=0; j < len; j++) {
        if(arr[i][j] == 1) count++;
      }
      if(max < count) {
        max = count;
        data = i;
      }
    }
    Node root = new Node(null, data, null);
    queue.add(root);


    while(!queue.isEmpty()) {
      Node node = queue.remove();
      int row = node.data;

      for(int i=0; i < len; i++) {
        boolean isChild = true;

        if(arr[row][i] == 1) {
          int j = row - 1;
          while(j >= 0) {
            if(arr[j][i] == 1) isChild = false;
            j--;
          }
          if(isChild) {
            Node child = new Node(null, i, null);
            if(node.left == null) {
              node.left = child;
              queue.add(node.left);
            }
            else {
              node.right = child;
              queue.add(node.right);
            }
          }
        }
      }
    }
    return root;
  }

  /**
   * Solution using topological sort.
   * We use the exact way of topological sorting for this.
   */
  public static Node createByTopoSort(int[][] arr) {
    int n = arr.length; //no of vertices for us.
    int inDegree[] = new int[arr.length];

    //calculate indegree
    for(int i=0; i < n; i++) {
      for(int j=0; j < n; j++) {
        if(arr[i][j] == 1) {
          inDegree[j]++;
        }
      }
    }

    List<Node> list = new ArrayList<Node>();
    Queue<Integer> queue = new LinkedList<Integer>();
    for(int i=0; i < n; i++) {
      if(inDegree[i] == 0) queue.add(i);
    }

    //Start storing the elements with indegree 0
    while(!queue.isEmpty()) {
      int vertex = queue.remove();
      list.add(new Node(null, vertex, null));
      for(int i=0; i < n; i++) {
        if(arr[vertex][i] == 1) {
          inDegree[i]--;
          if(inDegree[i] == 0) {
            queue.add(i);
          }
        }
      }
    }

    //simply create a tree from a list.
    int i=0, j=1;
    while(j < n) {
      list.get(i).left = list.get(j);
      j++;
      if(j == n) break;
      list.get(i).right = list.get(j);
      j++;
      i++;
    }

    return list.get(0);
  }


  public static void main(String[] args) {
    int arr[][] = new int[][] {
        {0,0,0,0,0,0},
        {1,0,0,0,1,0},
        {0,0,0,1,0,0},
        {0,0,0,0,0,0},
        {0,0,0,0,0,0},
        {1,1,1,1,1,0}
    };
    Node root = createTree(arr);
    BinaryTree.display(root);
    System.out.println();

    root = createByTopoSort(arr);
    BinaryTree.display(root);
    System.out.println();


    arr = new int[][]{
        {0,1,1},
        {0,0,0},
        {0,0,0}
    };
    root = createTree(arr);
    BinaryTree.display(root);

    System.out.println();
    root = createByTopoSort(arr);
    BinaryTree.display(root);
    System.out.println();
  }
}

/**
 * Lets first understand the problem statement. If arr[1,0] = 1 then 1 is a parent of 0.
 * For arr[5][2]=1 then 5 is parent of 2. We assume that the matrix given is correct enough to
 * generate us a proper tree. Eg, arr[1,1] != 1 because this means that 1 is a parent of 1 which
 * is not possible.
 *
 * Now lets observe the problem. We see that [1,0]=1 and [5,0]=1 which means that the ancestor of
 * 0 is 1 and 5. Likewise for other elements.
 *
 * The first step is to identify a root of a tree. The row that has maximum 1's is the root.
 * This is because the root is the highest ancestor. Now consider the row 5 which is the root.
 * Take a note of the slots in this row where the elements are 1. Eg. [5,0],[5,1],[5,2],[5,3],
 * [5,4] are all 1. This means, 5 is a parent of 0,1,2,3 and 4. But we need to find the immediate
 * child of 5. To find that take the columns 0,1,2,3 and 4 and which ever of these columns do not
 * have 1 while travelling upwards they are the immediate child of 5. Eg, col 1 and col 2 has no
 * 1's apart from [5,1] and [5,2]. This means that 1 and 2 does not have any other parent apart
 * from 5 hence the immediate child of 5 is 1 and 2.
 *
 * So we create a root node and store in queue. We follow the same approach to construct a tree.
 *
 */

/**
 * Another simple solution would be to create a Directed Asyclic Graph and perform
 * topological sorting.
 **/
