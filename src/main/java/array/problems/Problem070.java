package array.problems;

import java.util.Arrays;

public class Problem070 {

  public static void union(int arr[], int brr[]) {
    int i = 0, j = 0;
    System.out.println("Union: ");
    while(i < arr.length && j < brr.length) {
      if(arr[i] == brr[j]) {
        System.out.print(arr[i] + " ");
        i++; j++;
      }
      else if(arr[i] < brr[j]) {
        System.out.print(arr[i] + " ");
        i++;
      }
      else {
        System.out.print(brr[j] + " ");
        j++;
      }
    }

    //if arrays are unequal in length
    while(i < arr.length) {
      System.out.print(arr[i] + " ");
      i++;
    }

    while(j < brr.length) {
      System.out.print(brr[j] + " ");
      j++;
    }
    System.out.println();
  }

  public static void intersection(int arr[], int brr[]) {
    int i = 0, j = 0;
    System.out.println("Intersection: ");
    while(i < arr.length && j < brr.length) {
      if(arr[i] == brr[j]) {
        System.out.print(arr[i] + " ");
        i++; j++;
      }
      else if(arr[i] < brr[j]) {
        i++;
      }
      else {
        j++;
      }
    }
    System.out.println();
  }

  public static void util(int arr[], int brr[]) {
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(brr));
    union(arr, brr);
    intersection(arr,brr);
    System.out.println();
  }

  public static void main(String[] args) {
    util(new int[]{1, 3, 4, 5, 7}, new int[]{2, 3, 5, 6});

  }

}
