/**
 * Created by Avishek Gurung on 2021-06-21
 */

package basic.algo;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

import java.util.Stack;


/**
 * In preorder traversal, we traverse the root, left sub-tree and right sub-tree.
 *
 * For the tree
 *              1
 *         2        3
 *       4   5    6   7
 *
 * The traversal is 1 2 4 5 3 6 7
 */

public class BinaryTreePreorder {


    /**
     * The time complexity is O(n)
     * @param root
     */
    private static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    /**
     * The time complexity is O(n)
     * @param root
     */
    private static void preorderIteration(Node root) {
        Stack<Node> stack = new Stack<>();
        while(true) {
            while(root != null) {
                System.out.print(root.data + " ");
                stack.push(root);
                root = root.left;
            }

            if(stack.isEmpty()) break;
            root = stack.pop();
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Node root = BinaryTree.getTree();
        preorder(root);
        System.out.println();
        preorderIteration(root);
    }

}
