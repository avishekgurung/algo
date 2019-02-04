package tree.binary.problems;

public class Problem064 {
  /**
   * Rather than following a naive approach to traverse all the nodes, we can simply add
   * all the elements of leaf nodes and multiply by the level.
   *
   * Another approach is to find the total number of leaves by using 2^(level). Then put
   * these each element in a queue. Pop out two elements at a time, sum them up and add
   * the result in the queue. Perform this until we have only one element in a queue which
   * will be a final result.
   */
}
