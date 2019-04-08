package dp.general;

/**
 * This is just an extension of Subset Sum problem.
 *
 * Let n be the number of elements and m be the divider.
 *
 * if n > m then then there will be atleast one sum which will be divided by m (By Pigeon hole
 * principle)
 *
 * if n <= m
 * Take the sum of all elements. Solve this as a subset sum problem and at any element if we
 * get sum as true then divide that by m and check. If true, then stop there.
 *
 */
public class Problem005 {
}
