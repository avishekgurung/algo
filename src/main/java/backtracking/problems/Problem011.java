package backtracking.problems;

public class Problem011 {

    private boolean sumCombination(int arr[], int index, int sum, int TARGET) {
        if(index == arr.length) {
            return sum == TARGET;
        }

        return sumCombination(arr, index + 1, sum + arr[index], TARGET) ||
        sumCombination(arr, index + 1, sum - arr[index], TARGET);
    }

    private void util() {
        int arr[] = {3,4,5};
        int target = 4;
        System.out.println(sumCombination(arr, 1, arr[0], target));
    }

    public static void main(String[] args) {
        new Problem011().util();
    }

}
