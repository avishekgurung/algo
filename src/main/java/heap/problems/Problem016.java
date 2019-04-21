package heap.problems;

/**
 *
 * A simple solution would be, create a max heap of size 3. For every new
 * element from stream, insert them in the heap. Pop out three elements, find
 * the product, print it, and re-instore three elements into the heap again.
 *
 * Time complexity: For every element from stream, we perform pop and
 * insertion. Popping takes logk (removing element from arr[0],
 * arr[0]=arr[count-1],percolateDown(0)). Re-inserting takes logk. Now we
 * perform these operations for k times times, so k(logk^2). Hence,
 * considering that there are n elements, our total complexity would be
 * nk(logk^2).
 *
 * We can improve the complexity by using custom heap. Create a heap array of
 * size k. For every element from stream, insert the element in heap, iterate
 * the array and find the product. Insertion takes logk and iteration will take
 * k. So complexity = nklogk
 *
 * Efficient: Create a min heap of size k. Fill the min heap first with the elements
 * from stream. Now if every incoming element, check if the element is greater than
 * the root, if yes the remove the root and insert the element. Use removeAndReplace()
 * method so that we do both this op in logk i.e log3. When asked for the product
 * of triplets, don't pop the element from the heap, find the product and re-insert the
 * elements. Simply iterate the internal heap array and find the product. This will
 * also take O(nklogk). For triplets, k = 3, so its O(n).
 *
 */


/**
 * Another simple and efficient would be to find the largest 3 elements by using an algo
 * first = second = third = Integer.MIN_VAL
 * if(ele > first) {
 *   third = second;
 *   second = first;
 *   first = element;
 * }
 *
 * else if(ele > second) {
 *   third = second;
 *   second = element;
 * }
 *
 * else if(ele > third) {
 *   third = element;
 * }
 *
 * return first * second * third;
 *
 * This will not take extra space as heap does too.
 */
public class Problem016 {
}
