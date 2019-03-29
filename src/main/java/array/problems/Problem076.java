package array.problems;

/**
 * The array is sorted so we can use Binary Search but since the array is infinite we cannot
 * find the low and high for a binary search. So first we ll find low and high and then use BS.
 * We will follow a gallop search kind of method.
 *
 * 1. Let low = 0 and high = 1
 *    if element == high return high //element found
 *    if element < high //range found where the element will be present
 *      BST(low, high)
 *    else // still no clue of element
 *      low = high
 *      high = 2*high
 *
 */
public class Problem076 {
}
