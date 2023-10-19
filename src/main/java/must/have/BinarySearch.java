package must.have;

/**
 * @author ~ Avishek Gurung
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {3,4,5,6,7,8,9};
        int target = 1;
        System.out.println(binarySearch(arr, target));
    }


    /**
     * Performs search in O(logn)
     * @param arr
     * @param target
     * @return
     */
    private static int binarySearch(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
               return mid;
            }
            if(target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Performs search in O(logn)
     * @param arr
     * @return
     */
    private static int pivotSearch(int arr[]) {
        int left = 0;
        int right = arr.length - 1;

        if(arr[left] < arr[right]) return right; // No pivot present.

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] > arr[mid+1]) return mid;
            if(arr[left] > arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
