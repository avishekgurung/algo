package basic;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

/**
 * @author ~ Avishek Gurung
 */
public class LinkedListReverse {

    public static void main(String[] args) {
        Node node = LinkedListUtil.customBulkInsert(new int[]{1,2,3,4});
        LinkedListUtil.display(node);
        node = reverse(null, node);
        LinkedListUtil.display(node);
    }

    private static Node reverse(Node prev, Node node) {
        if(node == null) return prev;
        Node next = node.next;
        node.next = prev;
        return reverse(node, next);
    }

}
