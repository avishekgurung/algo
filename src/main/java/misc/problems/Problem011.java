package misc.problems;

/**
 * Here, the naive logic is to find 1 and then find next 1s which will take O(n2). The efficient
 * approach is to find the pair of ones which is given by k(k-1)/2 where k is the count of 1s.
 */
public class Problem011 {

  public static void substringWithStartAndEndAs1(String s) {
    System.out.println(s);
    int k = 0;
    for(int i=0; i < s.length(); i++) {
      if(s.charAt(i) == '1') k++;
    }

    int result = (k*(k-1))/2;
    System.out.println("The number of substrings that starts and ends in 1 is " + result + "\n");
  }

  public static void main(String[] args) {
    substringWithStartAndEndAs1("00100101");
    substringWithStartAndEndAs1("100101001");
  }
}
