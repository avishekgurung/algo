package array.problems;

public class Problem006 {

  public static int gallopSearch(int arr[]) {
    int i=1;

    while ( true ) { //Not using size of an array as it may take long to calculate it internally.
      if(arr[i] == 0) break;
      i = i * 2;
    }

    while(arr[i] != 1) {
      i--;
    }

    return i + 1;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
        1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
        ,0,0,0,0,0,0,0,0,0,0,0,0};
    System.out.println(gallopSearch(arr));
  }

}

/**
 * To make it more efficient.
 * Lets say that the list is really long. While galloping, we found 0 at index 5000. But the first
 * 0 is at 2500. Here we have to traverse 2500 backwards to get the first index of zero. To improve
 * the performance, we can always not the last value of i. When we find 0, then the first 0 would
 * lie between last value of i and current value of i. We can now use binary search to find the
 * first value of 0. The complexity decreases by log. So before, it would take 2500 and now it
 * will take log(2500)
 *
 */
