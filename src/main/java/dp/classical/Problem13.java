package dp.classical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem13 {

    public static void main(String[] args) {
        new Problem13().driver();
    }
    private void driver() {
        Set<String> dict = new HashSet<>(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango"));
        String string = "ilikesamsungs";
        System.out.println(isSegmented(string, dict));
    }

    private boolean isSegmented(String string, Set<String> dict) {
        String substring = "";
        for(int i=0; i < string.length(); i++) {
            substring = substring + string.charAt(i);
            if(dict.contains(substring)) {
                substring = "";
            }
        }
        return substring.equals("");
    }
}
