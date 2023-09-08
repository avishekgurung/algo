package tree.binary.problems;

public class Problem058 {
  /**
   * Let T be the tree and S is the subtree that needs to be checked.
   *
   * Approach 1.  Find the node in T whose value is equal to the root value of S.
   * Now check if these two nodes are identical or not.
   *
   * Approach 2. Find in-order and pre-order traversal of T and store them in an array,
   * iT[], pT[]. Find in-order and pre-order traversal of S and store them in array
   * iS[], pS[].
   * Check iS[] is a subarray of iT[] and pS[] is a sub-array of p[].
   *
   * We can also use post-order / level order in place of pre-order. But inorder has to be there.
   *
   *
   */
}
