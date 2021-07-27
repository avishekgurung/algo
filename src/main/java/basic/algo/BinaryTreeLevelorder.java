/**
 * Created by Avishek Gurung on 2021-06-21
 */

package basic.algo;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In levelorder traversal, we traverse the nodes in breadth first.
 *
 * For the tree
 *              1
 *         2        3
 *       4   5    6   7
 *
 * The traversal is 1 2 3 4 5 6 7
 */


public class BinaryTreeLevelorder {

    /**
     * The time complexity is O(n)
     * @param root
     */
    private static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            root = queue.remove();
            System.out.print(root.data + " ");
            if(root.left != null) queue.add(root.left);
            if(root.right != null) queue.add(root.right);
        }
    }

    /**
     * The time complexity is O(n)
     * @param root
     */
    private static void levelOrderWithLevels(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            root = queue.remove();
            if(root == null) {
                System.out.println();
                if(!queue.isEmpty()) queue.add(null);
            }
            else {
                System.out.print(root.data + " ");
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = BinaryTree.getTree();
        levelOrder(root);
        System.out.println("\n");
        levelOrderWithLevels(root);
    }

}
