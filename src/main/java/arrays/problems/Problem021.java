package arrays.problems;

public class Problem021 {

  /**
   * There are many ways to fix this problem by sorting, hashing etc. But the optimum is below
   * with time complexity as O(n) and space as O(1).
   * @param arr
   */
  public static void maxOccurrence(int arr[]) {
    int n = arr.length;
    int maxFreq= 0;
    int element=-1;

    for(int i=0; i < n; i++) {
      int index = arr[i] % n;
      arr[index] = arr[index] + n;
      if(arr[index]/n > maxFreq) {
        maxFreq = arr[index]/n;
        element = index;
      }
    }
    System.out.println("Element " + element + " occurs " + maxFreq + " times");
  }

  public static void main(String[] args) {
    int arr[] = new int[]{3,2,1,4,1};
    maxOccurrence(arr);

    System.out.println();
    arr = new int[]{1,2,1,2,1};
    maxOccurrence(arr);
  }
}
