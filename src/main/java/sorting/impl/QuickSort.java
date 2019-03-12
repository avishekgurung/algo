package sorting.impl;

import java.util.Arrays;

/**
 * Quick Sort takes one pivot element. We can select pivot element from anywhere but here we choose
 * the last element to be the pivot. Then we divide the array into two halves such that all the
 * elements lower than pivot falls to its left and all the elements higher than pivot will fall
 * to its right. Remember they are not yet sorted.
 * We continue to perform this step till we get a final sorted array.
 *
 * Time Complexity = O(nlogn).
 *
 * The best case for quicksort is when the pivot always lies in the middle. The best and the
 * average complexity is O(nlogn).
 *
 * The worst case is when the array is already reverse sorted. The complexity increases to O(n2).
 *
 */

public class QuickSort {

  public static void quickSort(int arr[], int left, int right) {
    if(left < right) {
      int pivot = getPivot(arr, left, right);
      quickSort(arr, left, pivot-1);
      quickSort(arr, pivot+1, right);
    }
  }

  private static int getPivot(int arr[], int left, int right) {
    int pivot = arr[right];
    int i = left;

    for(int j=left; j < right; j++) {
      if(arr[j] <= pivot) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        i++;
      }
    }

    int temp = arr[i];
    arr[i] = arr[right];
    arr[right] = temp;

    return (i);
  }

  public static void main(String[] args) {
    int arr[] = new int[]{9,4,8,1,2,6,3,7,5};
    quickSort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));

    arr = new int[]{70,51,96,50,83,87,99,34,18,51,20,55,44,76,58,29,74,48,8,44};
    quickSort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));

    arr = new int[]{45 ,50 ,35 ,62 ,41 ,7 ,42 ,19 ,8 ,15 ,69 ,45 ,100,21 ,7 ,81 ,48 ,58 ,37 ,75 ,67,
        5 ,38,71,94,10,10,30,61,1,37,38,51,29,51,25,29,10,76,57,58,91,31,20,24,78,91,37,80,85,42,
        62,25,4 ,2 ,49,76,47,17,11};
    quickSort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));

  }
}
/**
 * Quick sort Vs Merge sort.
 * We see that worst case for mergesort (or even heapsort) is O(nlogn) whereas for quicksort its
 * O(n2). Still, in some areas, quicksort is considered better than the other two:
 *
 * 1. Auxillary space: Mergesort uses O(n) extra space for sorting whereas Quicksort does not use
 * any extra space.
 *
 * 2. Worst Case: We know that Quicksort has O(n2) for worst cases but this can easily be avoided
 * by choosing pivot in such a way that worst case does not occur. So its complexity will be same
 * that of mergesort. (The pivot element is adjustable and we can make the pivot element as 1st,
 * mid or last element etc).
 *
 * How to choose sorting algorithms.
 *
 * 1. Bubblesort: When we do not want to use any sorting library for some reason and we quickly want
 * to sort ourselves. Its easy to implement so we can use it. We are less worried about
 * complexities eg while doing some poc etc.
 *
 * 2. Selection sort: When we do not want large number of swaps then we use selection sort as it
 * performs minimum swap.
 *
 * 3. Insertion sort: When array is almost sorted and we want to sort this array then we can use
 * this algo because it will run at nearly O(n). We assume that the array size is small.
 *
 * 4. Heapsort: If we are so much concerned about worst case complexity then we use Heapsort.
 * Lets say we want to sort numbers (and we do not want extra space so mergesort is ruled out)and
 * at no point, we want our sorting algo to go beyond nlogn then we can use heapsort. We can
 * also use this algo when there are problems related to streams, finding largest/smallest k
 * elements etc.
 *
 * 5. Quicksort: We can use quicksort in most of the cases as it uses no aux space. By adjusting
 * the pivot we can avoid the worst complexity of O(n2). This algo is considered the best of all
 * because the operations in the innermost loop are simpler making it 2-3 times faster than the
 * heap or merge sort of same worst complexity.
 *
 * 6. MergeSort: This sort is a stable sort i.e. it does not sort the same key elements. It uses
 * O(n) extra space which is its disadvantage. It is best for parallel processing and also for
 * sorting linkedlist.
 *
 * 7. BucketSort: When the list is small and we know what can be the largest element in a list. And
 * this largest element is also not huge. Eg, an array of n elements where n < some_small_value
 * and the elements are also in the range from 0 to n.
 *
 */
