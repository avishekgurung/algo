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
