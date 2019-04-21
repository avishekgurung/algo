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
   *
   * If the element is smaller than the heap root then do nothing.
   *
   * If k is the size of our heap and n is the number of elements in the file (or in the
   * stream), complexity =
   * n * ( removing top element + adding new element)
   * n * (logn + logn)
   * n * logn
   *
   * Offcourse we can make the second term as one single operation if we start using our custom
   * heap. Removing involves removing the top element and heapifying (percolateDown). So here,
   * we can replace arr[0] by new element and heapify it. This will be faster as we have removed
   * one extra process of insertion which will cost us logn.
   *
   */

}
