package backtracking.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ~ Avishek Gurung
 */
public class Problem001 {

    /**
     * Permutations is the arrangement of elements in a set. For a given set n, to find a permutation of r elements,
     * the formulae is nPr = n!/(n-r)!. But here, r=n, so nPn = n!
     */
    private void permutations(String prefix, String string, List<String> result) {
        if(string.equals("")) {
            result.add(prefix);
            return;
        }

        for(int i=0; i < string.length(); i++) {
            permutations(prefix + string.charAt(i), string.substring(0, i) + string.substring(i+1, string.length()), result);
        }
    }


    /**
     * Combination is the selection of elements from a given set. The time complexity is O(n2).
     */
    private void combinations(String prefix, String string, List<String> result) {
        if(!prefix.equals("")) result.add(prefix);
        if(string.equals("")) return;

        for(int i=0; i < string.length(); i++)
            combinations(prefix + string.charAt(i), string.substring(i+1, string.length()), result);
    }

    public static void main(String[] args) {
        Problem001 instance = new Problem001();
        String s1 = "AECDB";
        List<String> result = new ArrayList<>();
        instance.permutations("", s1, result);
        System.out.println(result);

        System.out.println("");
        result = new ArrayList<>();
        instance.combinations("", s1, result);
        System.out.println(result);
    }

}
