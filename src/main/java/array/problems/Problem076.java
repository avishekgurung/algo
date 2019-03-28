package array.problems;

/**
 * The array is sorted so we can use Binary Search but since the array is infinite we cannot
 * find the low and high for a binary search. So first we ll find low and high and then use BS.
 * We will follow a gallop search kind of method.
 *
 * 1. Let low = 0 and high = 1
 *    check the condition element >= low and element <= high
 *      if true then perform BS on low and high
 *      else
 *        high = 2 * high;
 *        low = high
 */
public class Problem076 {
}
