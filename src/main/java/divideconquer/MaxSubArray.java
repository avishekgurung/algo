package divideconquer;

public class MaxSubArray {

  private int[] maxSubArray(int arr[], int low, int high) {
    if(low == high) {
      return new int[] {low, high, arr[low]};
    }
    int mid = (low + high)/2;
    int[] leftResult = maxSubArray(arr, low, mid);
    int[] rightResult = maxSubArray(arr, mid+1, high);
    int[] crossResult = maxCrossSubArray(arr, low, mid, high);
    if(leftResult[2] >= rightResult[2] && leftResult[2] >= crossResult[2]){
      return leftResult;
    }
    else if(rightResult[2] >= leftResult[2] && rightResult[2] >= crossResult[2]) {
      return rightResult;
    }
    else {
      return crossResult;
    }
  }

  private int[] maxCrossSubArray(int arr[], int low, int mid, int high) {
    int sum = 0;
    int leftSum = Integer.MIN_VALUE;
    int maxLeft = 0;
    for(int i=mid; i >= low; i--) {
      sum = sum + arr[i];
      if(sum > leftSum) {
        leftSum = sum;
        maxLeft = i;
      }
    }

    sum = 0;
    int maxRight = 0;
    int rightSum = Integer.MIN_VALUE;
    for(int i=mid+1; i<=high; i++) {
      sum = sum + arr[i];
      if(sum > rightSum) {
        rightSum = sum;
        maxRight = i;
      }
    }

    return new int[]{maxLeft, maxRight, leftSum + rightSum};
  }

  public static void main(String[] args) {
    MaxSubArray obj = new MaxSubArray();
    int arr[] =  {-2, -5, 6, -2, -3, 1, 5, -6};
    int res[] = obj.maxSubArray(arr, 0, arr.length-1);
    System.out.println("Max sum: " + res[2]);
    System.out.println("Start index: " + res[0]);
    System.out.println("End index: " + res[2]);
  }

}


