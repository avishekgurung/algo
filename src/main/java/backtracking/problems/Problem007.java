package backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem007 {

    /**
     * String approach
     * We can take a string combination approach where we will find the combination of all the elements of string
     * and for combination that is of size k, we will print the result.
     *
     * Array approach
     * However, we can easily do this with an array as well, where we will find all the subset of an array and
     * the subset of size k will be printed.
     */
    public static void main(String[] args) {
        new Problem007().driver();
    }
    private void driver() {
        nCr(new int[]{1,2,3,4,5}, 0, new ArrayList<>(), 3);
    }

    private void nCr(int arr[], int index, List<Integer> aux, int k) {
        if(aux.size() == k) {
            System.out.println(aux);
            return;
        }

        if(index >= arr.length) return;

        for(int i=index; i < arr.length; i++) {
            List<Integer> auxCopy = new ArrayList<>(aux);
            auxCopy.add(arr[i]);
            nCr(arr, i+1, auxCopy, k);
        }
    }
}
