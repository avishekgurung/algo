package misc;

public class Problem009 {

  /**
   1) Initialize counts of different subsequences caused by different combination of ‘a’.
   Let this count be aCount.

   2) Initialize counts of different subsequences caused by different combination of ‘b’. Let this
   count be bCount.

   3) Initialize counts of different subsequences caused by different combination of ‘c’. Let this
   count be cCount.

   4) Traverse all characters of given string. Do following for current character s[i]
   If current character is ‘a’, then there are following possibilities :
   a) Current character begins a new subsequence.
   b) Current character is part of aCount subsequences.
   c) Current character is not part of aCount subsequences.
   Therefore we do aCount = (1 + 2 * aCount);

   If current character is ‘b’, then there are following possibilities :
   a) Current character begins a new subsequence of b’s with aCount subsequences.
   b) Current character is part of bCount subsequences.
   c) Current character is not part of bCount subsequences.
   Therefore we do bCount = (aCount + 2 * bCount);

   If current character is ‘c’, then there are following possibilities :
   a) Current character begins a new subsequence of c’s with bCount subsequences.
   b) Current character is part of cCount subsequences.
   c) Current character is not part of cCount subsequences.
   Therefore we do cCount = (bCount + 2 * cCount);

   5) Finally we return cCount;
   *
   */
  public static void noOfSubSequence(String s) {
    int aCount = 0, bCount = 0, cCount = 0;

    for(int i=0; i < s.length(); i++) {
      if(s.charAt(i) == 'a') {
        aCount = 1 + 2 * aCount;
      }
      else if(s.charAt(i) == 'b') {
        bCount = aCount + 2 * bCount;
      }
      else {
        cCount = bCount + 2 * cCount;
      }
    }
    System.out.println(s);
    System.out.println("Number of subsequences " + cCount + "\n");
  }

  public static void main(String[] args) {
    noOfSubSequence("abbc");
    noOfSubSequence("abcabc");
  }
}
