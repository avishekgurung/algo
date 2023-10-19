package backtracking.problems;

/**
 * @author ~ Avishek Gurung
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Approach 1: From a given string S, we will find all the combinations of t sized words. Now for each t sized words, we will
 * find the permutations. And for each permutations, we will check the valid word set.
 */
public class Problem002 {

    private void combination(String prefix, String str, int size, List<String> result) {
        if(prefix.length() == size) result.add(prefix);
        if(str.length() == 0) return;
        for(int i=0; i < str.length(); i++) {
            combination(prefix + str.charAt(i), str.substring(i+1, str.length()), size, result);
        }
    }

    private void permutations(String prefix, String str, List<String> result, Set<String> lookup) {
        if(str.length() == 0) {
            if(lookup.contains(prefix)) result.add(prefix);
            return;
        }
        for(int i=0; i < str.length(); i++) {
            permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()), result, lookup);
        }
    }


    private List<String> validWords(Set<String> valid, String str, int size) {
        List<String> combinations = new ArrayList<>();
        combination("", str, size, combinations);

        List<String> result = new ArrayList<>();
        for(String combination : combinations) {
            permutations("", combination, result, valid);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem002 _instance = new Problem002();
        String str = "ABCDE";
        Set<String> lookup = new HashSet<>();
        lookup.add("DEF");
        lookup.add("CAB");
        lookup.add("BED");

        /*
        List<String> result = _instance.validWords(lookup, str, 3);
        System.out.println(result);*/

        _instance.validWordsUtil(str, lookup, 3);

    }

    /**
     * Approach 2: The first approach generates combination of all letters (valid = 3 characters and invalid = more or
     * less than 3). We can trim down this problem to generate 3 sized words in an order. We can then process each of
     * these 3 sized words and find all its combinations and look into the valid words set.
     *
     * Eg for word = ABCDE, we will generate set of potential words [ABC, ABD, ABE, ACD, ACE, ADE, BCD, BCE, BDE, CDE]
     * Now for each word, we will do the permutations and find the required result.
     */

    private void validWordsUtil(String str, Set<String> lookup, int t) {
        List<String> potentialWords = new ArrayList<>();

        tSizedWords(str, "", 0, t, potentialWords);
        System.out.println(potentialWords);

        List<String> result = new ArrayList<>();

        for(String string : potentialWords) {
            permutations("", string, result, lookup);
        }

        System.out.println(result);
    }

    private void tSizedWords(String str, String result, int index, int t, List<String> list) {
        if(result.length() == t) {
            list.add(result);
            return;
        }

        for(int i=index; i < str.length(); i++) {
            tSizedWords(str, result + str.charAt(i), i+1, t, list);
        }

    }

}
