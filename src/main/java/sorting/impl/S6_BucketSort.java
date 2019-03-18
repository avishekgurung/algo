package sorting.impl;

import java.util.Arrays;

public class S6_BucketSort {

  public static void bucketSort(int arr[], int maxVal) {
    int bucket[] = new int[maxVal + 1];

    for(int i=0; i < bucket.length; i++) bucket[i] = 0;

    for(int i=0; i < arr.length; i++) bucket[arr[i]] = bucket[arr[i]] + 1;

    int k=0;
    for(int i=0; i < bucket.length; i++) {
      for(int j=0; j < bucket[i]; j++) {
        arr[k] = i;
        k++;
      }
    }
  }

  public static void bucketSortForFloat(float arr[], float maxVal) {
    int size = (int)(maxVal*10) + 1;
    int bucket[] = new int[size];

    for(int i=0; i < bucket.length; i++) bucket[i] = 0;

    for(int i=0; i < arr.length; i++) {
      int index = (int)(arr[i] * 10);
      bucket[index] = bucket[index] + 1;
    }

    int k = 0;
    for(int i=0; i < bucket.length; i++) {
      for(int j=0; j < bucket[i]; j++) {
        arr[k] = arr[bucket[j]];
        k++;
      }
    }

    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    int arr[] = new int[]{8,2,5,1,7,3,9,6};
    bucketSort(arr, 9);
    System.out.println(Arrays.toString(arr));

    arr = new int[]{9,4,3,1,3,2,3,4,1,2,3,4,1,2,4,5,2,1};
    bucketSort(arr, 9);
    System.out.println(Arrays.toString(arr));
    //float arr_f[] = new float[]{0.656f ,0.3434f, 0.565f , 0.1234f , 0.897f,0.665f};
    //bucketSortForFloat(arr_f, 0.897f);
  }
}

/**
 * Time complexity = O(n)
 *
 * Disadvantages:
 * 1. We need to have some info (max element) before performing sorting.
 * 2. If the elements are widely distributed then memory will be wasted. Eg, sorting
 *    {2,100000,3}. The array of size 100001 is created to sort 3 elements.
 */
