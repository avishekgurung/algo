package basic;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

/**
 * @author ~ Avishek Gurung
 */
public class LinkedListMid {

    public static void main(String[] args) {
        Node node = LinkedListUtil.customBulkInsert(new int[] {1});
        System.out.println(mid(node).data);
    }

    private static Node mid(Node node) {
        Node pointer1 = node;
        Node pointer2 = node.next;

        while(pointer2 != null) {
            pointer2 = pointer2.next;
            if(pointer2 == null) break;
            pointer2 = pointer2.next;
            pointer1 = pointer1.next;
        }

        return pointer1;
    }

}
