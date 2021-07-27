/**
 * Created by Avishek Gurung on 2021-06-21
 */

package basic.algo;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

import java.util.Stack;

/**
 * In inorder traversal, we traverse the left sub-tree, root and right sub-tree.
 *
 * For the tree
 *              1
 *         2        3
 *       4   5    6   7
 *
 * The traversal is 4 2 5 1 6 3 7
 */

public class BinaryTreeInorder {

    /**
     * The time complexity is O(n)
     * @param root
     */
    private static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    /**
     * The time complexity is O(n)
     * @param root
     */
    private static void inorderIteration(Node root) {
        Stack<Node> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) break;
            root = stack.pop();
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Node root = BinaryTree.getTree();
        inorder(root);
        System.out.println();
        inorderIteration(root);
    }
}
