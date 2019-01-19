package tree.binarysearch.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;
import tree.binary.utils.BinaryTree;

public class Problem012 {

  public static tree.binary.utils.Node convert(Node node) {
    if(node == null) return null;
    Node mid = getMid(node);
    Node next = mid.next;
    mid.next = null;
    tree.binary.utils.Node bstNode = new tree.binary.utils.Node(null, mid.data, null);
    if(next == null) return bstNode;
    bstNode.left = convert(node);
    bstNode.right = convert(next);
    return bstNode;
  }

  private static Node getMid(Node node) {
    if(node == null || node.next == null) return node;
    Node prev = null;
    Node pointer = node;
    Node mid = node;
    while(pointer != null) {
      pointer = pointer.next;
      if(pointer == null) break;
      pointer = pointer.next;
      prev = mid;
      mid = mid.next;
    }
    prev.next = null;
    return mid;
  }

  public static void main(String[] args) {
    Node node = LinkedListUtil.customBulkInsert(new int[]{1,2,3,4,5,6,7});
    LinkedListUtil.display(node);
    tree.binary.utils.Node root = convert(node);
    BinaryTree.display(root);
  }

}
