package practice;

import java.util.*;

class Practice {

    public static void main(String[] args) {

        new Practice().util();
    }



    private void util() {

        int arr[] = {2,5,8,9,100};
        //int arr[] = {1,2,3,4};
        int total = 0;
        for(Integer e : arr) total = total + e;
        minDiff = Integer.MAX_VALUE;
        recur(0, 0, arr, total, new HashMap<>());
        System.out.println("Answer: " + minDiff);
        System.out.println(count);
    }






    /**
     * Implementation starts from here!
     */

    private static int count = 0;
    private static int minDiff = Integer.MAX_VALUE;
    private void recur(int index, int sum, int arr[], int total, Map<String, Integer> dp) {
        if(index > arr.length) return;
        String key = index + " : " + sum;
        if(dp.containsKey(key)) return;

        int sumSet1 = sum;
        int sumSet2 = Math.abs(total - sum);
        int diff = Math.abs(sumSet1 - sumSet2);
        minDiff = Math.min(minDiff, diff);

        count++;
        for(int i=index; i < arr.length; i++) {
            recur(i + 1, sum + arr[i], arr, total, dp);
        }
        dp.put(key, diff);
    }

}
