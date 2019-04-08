package practice;

public class LabTest {

  public static void test(int arr[], int n) {
    if(n < 0) return;

    System.out.println(arr[n]);
    for(int i=1; i <= n; i++) {
      test(arr, n - i);
    }
  }

  public static void main(String[] args) {
    test(new int[]{1,2,3}, 2);
  }
}
