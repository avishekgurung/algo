package heap.problems;

public class Problem007 {
  /**
   *  Heap has to follow two properties:
   *  1. A node value should be greater than its children.
   *  2. The tree should be a complete tree i.e. all its leaf should be at
   *  height h or h-1
   *
   *  Perform a level order traversal and check every node is greater than its
   *  children. In this same traversal, keep track of the level as well.
   *  When a first leaf is encountered store its level. Now when any other leaves
   *  are encountered, find the difference between the level of the first leaf and
   *  the current leaf level. If the difference is more than 1 then its not a heap.
   *
   *
   */
}
