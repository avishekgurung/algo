package backtracking.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ~ Avishek Gurung
 */
public class Problem005 {

    /**
     * Naive approach. For a given n = 3, I will take an array/string as 123123, then I will create all possible
     * permutations and check for each permutation.
     *
     * Time complexity.
     * For n, we are generating permutation of 2n which is 2^2n
     * For verification, we use n
     * O(n) = 2^2n * n = 2^2n+1 ~ 2^n
     *
     * Space complexity.
     * We use a set for verification. But we do not use for all permutations, we only use for those that has not been
     * verified earlier. So considering that each number is duplicated once, we might be processing exactly half of our
     * total permutations. That gives us space complexity to O(2^n)
     */

    private static Set<String> processed = new HashSet<>();

    private void permuatation(String prefix, String str) {
        if(str.length() == 0) {
            //System.out.println(prefix);
            verify(prefix);
            return;
        }

        for(int i=0; i < str.length(); i++) {
            permuatation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
        }
    }

    private void verify(String str) {
        /**
         * We are not processing unique elements. Each element is repeated twice so its permutation will also lead to
         * lot of duplicate strings. So in that case, we will use a filter to avoid processing same elements multiple
         * times.
         */
        if(processed.contains(str)) return;
        processed.add(str);

        Set<Character> lookup = new HashSet<>();
        char arr[] = str.toCharArray();
        try {
            for(int i=0; i < arr.length; i++) {
                char element = arr[i];
                int dist = Character.getNumericValue(element);
                if(!lookup.contains(element)) {
                    if(element == arr[dist+i+1])
                        lookup.add(element);
                    else return;
                }
            }
            System.out.println(str);
        } catch (Exception e) {}
    }

    private void soln1(int n) {
        String str = "";
        for(int i=1; i <= n; i++) {
            str = str + i;
        }
        str = str + str;
        permuatation("", str);
    }


    /**
     * This is a simpler solution. We can understand with example. Say n = 3.
     * We use a backtracking method where we will first fill the first place by 1 and try all the remaining combinations.
     * We will continue this for other elements as well.
     *
     * Likewise, in our first step, we will recursively start filling with 2 and so on.
     *
     */


    private void backtrack(int arr[], int x) {
        if(x > arr.length / 2) System.out.println(Arrays.toString(arr));

        for(int i=0; i < arr.length; i++) {
            if((i+1+x) < arr.length && arr[i] == 0 && arr[i+x+1] == 0) {
                arr[i] = x;
                arr[i+x+1] = x;
                backtrack(arr, x + 1);
                arr[i] = 0;
                arr[i+1+x] = 0;
            }
        }
    }

    private void soln2(int n) {
        int arr[] = new int[2*n];
        backtrack(arr, 1);
    }

    public static void main(String[] args) {
        //new Problem005().soln1(3);
        new Problem005().soln2(3);
    }


}
