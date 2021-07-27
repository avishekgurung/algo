/**
 * Created by Avishek Gurung on 2021-06-21
 */

package basic.algo;


import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

import java.util.Stack;

/**
 * In postorder traversal, we traverse the left sub-tree, right sub-tree and root.
 *
 * For the tree
 *              1
 *         2        3
 *       4   5    6   7
 *
 * The traversal is 4 5 2 6 7 3 1
 */

public class BinaryTreePostorder {

    /**
     * The time complexity is O(n)
     * @param node
     */
    private static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * The time complexity is O(n)
     * @param root
     */
    private static void postOrderIteration(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> aux = new Stack<>();
        while(true) {
            while(root != null) {
              aux.push(root);
              stack.push(root);
              root = root.right;
            }
            if(stack.isEmpty()) break;
            root = stack.pop();
            root = root.left;
        }

        while(!aux.isEmpty()) {
            System.out.print(aux.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = BinaryTree.getTree();
        postOrder(root);
        System.out.println();
        postOrderIteration(root);
    }
}
