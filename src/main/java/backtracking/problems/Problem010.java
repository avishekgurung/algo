package backtracking.problems;

public class Problem010 {

    public static void main(String[] args) {
        String word = "ABCCED";
        char arr[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        for(int i=0; i < arr.length; i++) {
            for(int j=0; j < arr[i].length; j++) {
                boolean result = wordSearch(arr, i, j, "", 0, word);
                if(result) {
                    System.out.println("Word found!");
                    return;
                }
            }
        }
        System.out.println("Word NOT found!");
    }
    private static boolean wordSearch(char arr[][], int i, int j, String result, int index, String target) {
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || index >= target.length()) return false;
        if(arr[i][j] != target.charAt(index)) return false;
        result = result + arr[i][j];
        if(result.equals(target)) return true;
        char item = arr[i][j];
        arr[i][j] = '\0';
        boolean top = wordSearch(arr, i-1, j, result, index + 1, target);
        boolean bottom = wordSearch(arr, i+1, j, result, index + 1, target);
        boolean left = wordSearch(arr, i, j-1, result, index + 1, target);
        boolean right = wordSearch(arr, i, j+1, result, index + 1, target);
        arr[i][j] = item;
        return top || bottom || left || right;
    }

}
