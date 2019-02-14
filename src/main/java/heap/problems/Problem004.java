package heap.problems;

public class Problem004 {

  /**
   * Sol 1
   * The solution would be to use a heap.
   * 1. Pick a first 1000 elements and insert them in a max heap.
   * 2. Remove the first 10 elements which are the highest among these 1000 elements.
   * Now empty the heap.
   * 3. Now take 990 elements and add them in a heap along the above 10.
   *
   * Perform this operation of picking up 990 elements and inserting into the heap
   * along with the last 10 elements achieved from the prev process.
   *
   * When all the elements are exhausted, pick the 10 elements from the heap which
   * will be the highest 10 of all the billion numbers.
   *
   */


  /**
   * Create a min heap of 10 elements.
   *
   * Iterate through the source (in chunk or in bulk if memory allows).
   *
   * For every element check if it is greater than the heap root.
   *
   * If the element is greater than the heap root,
   *  simply remove the root
   *  add the element
   *  Implementation wise, this can be a single step.
   *    arr[0] = element;
   *    percolateDown(0);
   *
   * If the element is smaller than the heap root then do nothing.
   *
   *
   * Rather than using a pre-build heap if we can use our own heap implementation
   * then the above step to remove the root and add an element will be a single
   * step, hence efficient.
   * Else, in pre-built heap, it would involve, removing the top element (which
   * internally removes arr[0], brings the last element to arr[0] and
   * percolatesDown(0). And then insertion happens.
   *
   * This solution is better than the above.
   *
   */

}
