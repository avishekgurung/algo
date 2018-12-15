package generic;

public class Problem0002 {

  public static void main(String[] args) {

    int arr[] = {1,2,3,4};

    int left = arr.length-1;

    while(left != 0) {
      System.out.println("x");
      int i = 0;
      int j = left;

      while(i < j) {
        arr[i] = arr[i] + arr[j];
        i++;
        j--;
        System.out.println("y");
      }
      if(i >= j) {
        left = j;
      }
    }

    System.out.println(arr[0]);

  }

}
