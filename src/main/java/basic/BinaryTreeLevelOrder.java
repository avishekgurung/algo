package basic;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ~ Avishek Gurung
 */
public class BinaryTreeLevelOrder {

    public static void main(String[] args) {
        Node node = BinaryTree.getTree();
        levelOrderTraversal(node);
    }


    private static void levelOrderTraversal(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        while(!queue.isEmpty()) {
            node = queue.remove();
            if(node == null) {
                if(!queue.isEmpty() && queue.peek() != null) { //Avoiding null addition loop
                    queue.add(null);
                }
                System.out.println();
            } else {
                System.out.print(node.data + " ");
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
    }
}
