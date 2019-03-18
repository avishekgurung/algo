package string.problems;

public class Problem005 {

  public static void permutation(String prefix, String string) {
    int len = string.length();
    if(len == 0){
      System.out.println(prefix);
      return;
    }

    for(int i=0; i < len; i++) {
      permutation(prefix + string.charAt(i), string.substring(0,i) +
          string.substring(i+1, len) );
    }
  }

  public static void combination(String prefix, String string) {
    int len = string.length();
    if(len == 0) {
      System.out.println(prefix);
      return;
    }
    for(int i=0; i < len; i++) {
      combination(prefix + string.charAt(i), string.substring(i+1, len));
    }
  }


  public static void main(String[] args) {
    System.out.println("Permutation");
    permutation("", "abc");
    System.out.println("\nCombination");
    combination("", "abc");
  }

}
