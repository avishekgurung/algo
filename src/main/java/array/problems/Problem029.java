package array.problems;

import java.util.Arrays;

/**
 * @author ~ Avishek Gurung
 */


/**
 * The solution is pretty simple. We first need to identify how the elements get displaced when we rotate them by 90.
 * From the top view, rotate the array by 90 deg. That should be the output.
 *
 * Now to get the rotated view, we can just see how we can actually adjust the elements. Here, the last row is being
 * converted to first column.
 */
public class Problem029 {
    public static void main (String args[]) {

        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};

        rotate2DArrayByNtimes(arr, 2);
    }

    public static void print(int arr[][]) {
        for(int i=0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

    public static void rotate2DArrayByNtimes(int arr[][], int n) {
        print(arr);
        for(int i=0; i < n; i++) {
            arr = rotateBy90(arr);
            print(arr);
        }
    }

    public static int[][] rotateBy90(int arr[][]) {
        int aux[][] = new int[arr.length][arr[0].length];

        for(int j=0, x=0; j < arr.length; j++, x++) {
            for(int i=arr.length-1, y=0; i >= 0; i--, y++) {
                aux[x][y] = arr[i][j];
            }
        }
        return aux;
    }
}
