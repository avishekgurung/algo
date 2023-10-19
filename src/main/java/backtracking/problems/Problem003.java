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


    /**
     * The time complexity of this method is O(n2).
     * This method is just an extension of String combination logic.
     * We are following the same logic but since we are passing prefix as a collection, so a reference is passed. Hence,
     * we need to be aware of these methods.
     */
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
