package backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem009 {

    public static void main(String[] args) {
        int arr[] = {2,3,5};
        combinationSum(arr, 0, 0, new ArrayList<>(), 8);
    }
    private static void combinationSum(int arr[], int index, int sum, List<Integer> result, int target) {
        if(sum == target) {
            System.out.println(result);
            return;
        }

        if(sum > target) return;

        for(int i=index; i < arr.length; i++) {
            List<Integer> aux = new ArrayList<>(result);
            aux.add(arr[i]);
            combinationSum(arr, i, sum + arr[i], aux, target);
        }

    }

}
