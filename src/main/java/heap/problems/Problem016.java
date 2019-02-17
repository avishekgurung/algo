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
 *
 */

public class Problem016 {
}
