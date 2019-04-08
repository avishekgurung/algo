package dp.general;

import java.util.ArrayList;
import java.util.List;

public class Problem010 {

  public static void golombSequence(int n) {
    List<Integer> golomb = new ArrayList<Integer>();
    golomb.add(0);
    golomb.add(1);
    golomb.add(2);
    golomb.add(2);

    for(int i=3; i <=n; i++) {
      int j = golomb.get(i);
      while(j != 0) {
        golomb.add(i);
        j--;
      }
    }

    for(int i=1; i <=n; i++) {
      System.out.print(golomb.get(i) + " ");
    }
    System.out.println("\n");
  }

  public static void main(String[] args) {
    golombSequence(4);
    golombSequence(6);
    golombSequence(7);
    golombSequence(11);
    golombSequence(50);
  }

}
