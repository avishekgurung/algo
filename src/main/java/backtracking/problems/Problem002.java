package backtracking.problems;

/**
 * @author ~ Avishek Gurung
 */

import java.util.*;

/**
 * Approach 1: From a given string S, we will find all the combinations of t sized words. Now for each t sized words, we will
 * find the permutations. And for each permutations, we will check the valid word set.
 *
 * Below Approach:
 * 1. Sort the given string. (This will help us later in our comparison with the dictionary)
 * 2. Run the combination for this string and identify all the t sized words, which are our potential words.
 * 3. Compare these t sized words with the dictionary where the word of dictionary has to be sorted before comparing.
 *
 * Approach 3:
 * 1. Run through every word of dictionary.
 * 2. For every word, run through its alphabets and check if each alphabet is present in the given word. If yes, then
 * we found the required word.
 *
 */
public class Problem002 {

    public static void main(String[] args) throws Exception {
        new Problem002().driver();
    }

    private void driver() {
        String str = "AECDB";
        str = sort(str);
        List<String> dictionary = new ArrayList<>(Arrays.asList("BAD", "AMI", "CAB", "BAC", "DEA", "AEF"));
        System.out.println(dictionary);
        Set<String> result = new HashSet<>();
        nCr("", 0, str, result, 3);
        System.out.println(result);
        compare(result, dictionary);
    }

    private void compare(Set<String> words, List<String> dictionary) {
        for(String string : dictionary) {
            String revStr = sort(string);
            if(words.contains(revStr)) System.out.println(string);
        }
    }

    private String sort(String string) {
        char arr[] = string.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }


    private void nCr(String prefix, int index, String string, Set<String> result, int t) {
        if(prefix.length() == t) {
            result.add(prefix);
            return;
        }
        if(index >= string.length()) return;

        for(int i=index; i < string.length(); i++) {
            nCr(prefix + string.charAt(i), i+1, string, result, t);
        }
    }

}
