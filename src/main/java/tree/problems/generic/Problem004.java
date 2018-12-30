package tree.problems.generic;

public class Problem004 {

  public static int findHeight(int arr[]) {
    int maxHeight = 0;

    for(int i=0; i < arr.length; i++) {
      int height = 0;
      int index = i;
      while(arr[index] != -1) {
        height++;
        index = arr[index];
      }

      if(height > maxHeight) maxHeight = height;
    }
    return maxHeight;
  }

  public static void main(String[] args) {
    int arr[] = new int[] {-1,0,1,6,6,0,0,2,7};
    System.out.println(findHeight(arr));
  }
}

/**
 *  First create a tree from the arr. This will give some clear picture on how we can solve.
 *  Its like we are traversing the tree upwards until we dont find the root.
 */
