package basic;

/**
 * @author ~ Avishek Gurung
 */
public class KadaneAlgo {
    public static void main(String[] args) {
        //int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        int arr[] = {5,4,-1,7,8};
        kadaneAlgo(arr);
    }

    private static void kadaneAlgo(int arr[]) {

        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;

        int maxTillHere = arr[0];
        int maxSum = arr[0];

        for(int i=1; i < arr.length; i++) {
            if(arr[i] > arr[i] + maxTillHere) {
                maxTillHere = arr[i];
                start = i;
                end = i;
            } else {
                maxTillHere = maxTillHere + arr[i];
                end = i;
            }

            if(maxSum < maxTillHere) {
                maxSum = maxTillHere;
                maxStart = start;
                maxEnd = end;
            }
        }

        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Start index: " + maxStart + " and end index: " + maxEnd);

    }
}
