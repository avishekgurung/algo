package array.problems;

public class Problem006 {

  public static int gallopSearch(int arr[]) {
    int size = arr.length;
    int i=1;

    while ( i < size ) {
      if(arr[i] == 0) {
        while(i != 0) {
          if(arr[i] == 1) {
            return i+1;
          }
          i--;
        }
      }
      i = i * 2;
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
        1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
        ,0,0,0,0,0,0,0,0,0,0,0,0};
    System.out.println(gallopSearch(arr));
  }

}
