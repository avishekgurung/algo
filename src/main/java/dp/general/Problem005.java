package dp.general;

import java.util.HashMap;
import java.util.Map;

public class Problem005 {
    public static void main(String[] args) {
        int arr[] = {3, 1, 7, 5};
        int k = 14;
        System.out.println(subsetSum(arr, 0, 0, k, new HashMap<>()));
    }
    private static boolean subsetSum(int arr[], int index, int sum, int k, Map<String, Boolean> lookup) {
        if(sum !=0 && sum % k == 0) {
            return true;
        }
        if(lookup.containsKey(index+""+sum)) return lookup.get(index+""+sum);
        if(index >= arr.length) return false;
        boolean result = false;
        for(int i=index; i < arr.length; i++)
            result = result || subsetSum(arr, i+1, sum + arr[i], k, lookup);
        lookup.put(index+""+sum, result);
        return result;
    }

}
