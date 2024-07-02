package backtracking.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ~ Avishek Gurung
 */
public class Problem005 {

    /**
     * A naive approach would be take an array, eg if n=3, [1,2,3]. Generate a permutation of the elements and for each
     * permutation, check if these elements can hold in an array of size 2n as per the conditions provided.
     */


    /**
     * This is a simpler solution. We can understand with example. Say n = 3.
     * We use a backtracking method where we will first fill the first place by 1 and try all the remaining combinations.
     * We will continue this for other elements as well.
     * Likewise, in our first step, we will recursively start filling with 2 and so on.
     */


    private void backtrack(int arr[], int x) {
        if(x > arr.length / 2) System.out.println(Arrays.toString(arr));

        for(int i=0; i < arr.length; i++) {
            if((i+1+x) < arr.length && arr[i] == 0 && arr[i+x+1] == 0) {
                arr[i] = x;
                arr[i+x+1] = x;
                backtrack(arr, x + 1);
                arr[i] = 0;
                arr[i+1+x] = 0;
            }
        }
    }

    private void soln2(int n) {
        int arr[] = new int[2*n];
        backtrack(arr, 1);
    }

    public static void main(String[] args) {
        //new Problem005().soln1(3);
        new Problem005().soln2(3);
    }


}
