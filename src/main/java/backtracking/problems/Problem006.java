package backtracking.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ~ Avishek Gurung
 */
public class Problem006 {

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        String arr[] = new String[digits.length()];
        for(int i=0; i < digits.length(); i++) {
            arr[i] = map.get(digits.charAt(i));
        }

        List<String> finalResult = new ArrayList();
        backtrack("", 0, arr, finalResult);
        return finalResult;

    }

    private void backtrack(String result, int index, String arr[], List<String> finalResult) {
        if(index >= arr.length) {
            finalResult.add(result);
            return;
        }

        for(int i=0; i < arr[index].length(); i++) {
            String newResult = result + arr[index].charAt(i);
            backtrack(newResult, index + 1, arr, finalResult);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem006().letterCombinations("23"));
        System.out.println(new Problem006().letterCombinations("289"));
    }

}
