package array.problems;

import java.util.Arrays;
import java.util.Random;

public class Problem047 {

  public static void shuffle(int arr[]) {
    int len = arr.length - 1;
    for(int i=0; i < arr.length; i++) {
      int random = getRandom(i, len);
      int temp = arr[random];
      arr[random] = arr[i];
      arr[i] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }


  private static int getRandom(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    System.out.println(Arrays.toString(arr));
    System.out.println("\nShuffled");
    shuffle(arr);
    shuffle(arr);
    shuffle(arr);
    shuffle(arr);
    shuffle(arr);
    shuffle(arr);
    shuffle(arr);
    shuffle(arr);
  }

}
