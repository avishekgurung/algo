package backtracking.problems;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ~ Avishek Gurung
 * Remember if we want to generate a subarray, then they are in the format:
 *
 * [1,2,3] = 1, 12, 13, 2, 23, 3, 123
 */
public class Problem003 {

    private void subArray(List<Integer> prefix, int pivot, int arr[]) {
        if(prefix.size() > 0) System.out.println(prefix);
        if(pivot >= arr.length) return;

        for(int i=pivot; i < arr.length; i++) {
            List<Integer> copy = new ArrayList<>(prefix);
            copy.add(arr[i]);
            subArray(copy, i+1, arr);
        }
    }

    public static void main(String[] args) {

        int arr[] = {1,2,3,4};
        new Problem003().subArray(new ArrayList<>(), 0, arr);

    }

}
