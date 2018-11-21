package linkedlist.problems;

/**
 * We know that Doubly Linked List traverse back and forth. But it uses two
 * pointers that stores the address of previous and next node. Since every
 * node has two address saved so it takes more memory.
 *
 * We can use Linked List to traverse back and forth. The LinkedList will not
 * store an address of next pointer but it will store a XOR of prev and next
 * address. So this approach is memory efficient and its also called Memory
 * Efficient Doubly Linked List.
 *
 * Lets first remember the Truth Table of XOR operation
 *
 * 1 XOR 1 = 0
 * 1 XOR 0 = 1
 * 0 XOR 1 = 1
 * 0 XOR 0 = 0
 *
 * Every node will store a XOR operation of prev and next node's address.
 *
 * Lets consider a Linked List
 *
 * A -> B -> C -> D
 *
 * Let a,b,c,d be the memory address of A,B,C and D respectively.
 *
 * Node A will store 0 X b
 * Node B will store a X c
 * Node C will store b X d
 * Node D will store c X 0
 *
 * To find the address of next pointer, we do address of prev XOR pnr of current
 * where pnr is the pointer of a Node.
 *
 * Traversing forward
 *
 *  Step 1. We are at node A
 *    Address of next pointer = address of prev XOR pnr(A)
 *    Address of next pointer = 0 X (0 X b) since pnr(A) = 0 X b
 *    Address of next pointer = O X (b)
 *    Address of next pointer = b
 *    Now we can go to next node B since we have its address
 *
 *  Step 2. We are at node B
 *    Address of next pointer = address of prev XOR pnr(B)
 *    Address of next pointer = a X (a X c)
 *    Address of next pointer = (a X a) X c
 *    Address of next pointer = 0 X c
 *    Address of next pointer = c
 *
 *  So likewise, we can move forward.
 *
 *  Traversing backward:
 *  Step 1. We are at node D
 *    Address of next pointer = pnr(D) X address of prev
 *    Address of next pointer = (c X 0) X 0 (remember we are moving back)
 *    Address of next pointer =  c
 *
 *  Step 2. We are at node C
 *    Address of next pointer = pnr(C) X address of prev
 *    Address of next pointer = (b X d) X d
 *    Address of next pointer = b X (d X d)
 *    Address of next pointer = b X 0
 *    Address of next pointer = b
 *
 *   Likewise we can move backwards too.
 *
 *   Since we saw that we need direct access of a node's address so this type
 *   of LinkedList is not possible to create in Java since we do not have access
 *   to memory address in Java.
 *
 *
 */

public class Problem018 {
}
