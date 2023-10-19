package practice;

import java.util.*;

class Practice {
    public static void main(String[] args) {

        new Practice().util();
    }

    private void util() {
        int arr[] = {5,7,2,3,4,5,1};

        System.out.println(recur(arr, 0));
    }


  private int recur(int arr[], int index) {
        if(index == arr.length - 1) return 1;

        int element = arr[index];

        int result = 1;

        for(int i=index+1;  i< arr.length; i++) {
            int subResult = recur(arr, i );
            if(element < arr[i]) {
                result = Math.max(result, subResult + 1);
            }
        }

        return result;
  }

}
