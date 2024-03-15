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

        //_instance.validWordsUtil(str, lookup, 3);
        _instance.validWordsUtil1(str, lookup, 3);

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


    /**
     * We can optimize further. In the above solution, we have identified all the potential words (which are t sized words)
     * and then we are taking the permutation of these words. The second step of permutation can be completely cut off.
     *
     * For a given string we will sort this string. Sorting this string will be helpful later when we do the comparison.
     * Now we will generate a set of three digit words with different combination. The set generated will also be of
     * sorted words. (Check general combination logic)
     *
     * So if a string is ADECB, we will have [ABC, ACD, ADE, BCD, BDE, ABD, ACE, ABE, BCE, CDE]
     *
     * Now iterate the words collection and for each word, sort them and check them in the set.
     *
     */


    private String sort(String str) {
        char arr[] = str.toCharArray();

        for(int i=0; i < arr.length-1; i++) {
            for(int j=i+1; j< arr.length; j++) {
                if(arr[i] > arr[j]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return new String(arr);
    }


    private void combination(String prefix, String str, int t, Set<String> set) {
        if(prefix.length() == t) {
            set.add(prefix);
        }
        if(str.length() == 0) return;

        for(int i=0; i < str.length(); i++) {
            combination(prefix + str.charAt(i), str.substring(i+1, str.length()), t, set);
        }

    }

    private void validWordsUtil1(String str, Set<String> words, int t) {
        str = sort(str);

        Set<String> set = new HashSet<>();
        combination("", str, t, set);

        for(String word: words) {
            String sortedWord = sort(word);
            if(set.contains(sortedWord)) {
                System.out.println(word);
            }
        }
    }

}
