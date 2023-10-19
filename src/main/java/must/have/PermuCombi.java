package must.have;

/**
 * @author ~ Avishek Gurung
 */
public class PermuCombi {


    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("Permutations");
        permutation("", str);

        System.out.println("\nCombinations");
        combination("", str);
    }


    private static void permutation(String prefix, String str) {

        if(str.equals("")) {
            System.out.println(prefix);
            return;
        }

        int length = str.length();

        for(int i=0; i < str.length(); i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, length));
        }
    }


    private static void combination(String prefix, String str) {
        System.out.println(prefix);
        if(str.equals("")) {
            return;
        }

        int length = str.length();

        for(int i=0; i < length; i++) {
            combination(prefix + str.charAt(i), str.substring(i+1, length));
        }
    }

}
