package heap.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem013 {

  static class Data {
    int sum;
    int i;
    int j;

    Data(int sum, int i, int j) {
      this.sum = sum;
      this.i = i;
      this.j = j;
    }

    public int getSum() {
      return sum;
    }
  }

  private static void kMaxSumCombinations(Integer a[], Integer b[], Integer k) {
    Arrays.sort(a, Collections.reverseOrder());
    Arrays.sort(b, Collections.reverseOrder());
    Comparator<Data> dataComparator = Comparator.comparing(Data::getSum, Collections.reverseOrder());
    PriorityQueue<Data> maxHeap = new PriorityQueue<>(dataComparator);
    maxHeap.add(new Data(a[0] + b[0], 0, 0));


    while(k>0 && !maxHeap.isEmpty()){
      Data data = maxHeap.remove();
      System.out.println(data.i + " + " + data.j + " = " + data.sum);
      int i = data.i;
      int j = data.j;

      if(j + 1 < b.length)
        maxHeap.add(new Data(a[i] + b[j+1], i, j+1));

      if(i + 1 < a.length)
        maxHeap.add(new Data(a[i+1] + b[j], i+1, j));
      k--;
    }

    System.out.println();

  }


  public static void main(String[] args) {
    Integer a[] = new Integer[]{3,2};
    Integer b[] = new Integer[]{1,4};
    /*Integer k = 2;
    kMaxSumCombinations(a,b,k);

    k = 10;
    kMaxSumCombinations(a,b,k);

    a = new Integer[]{1,4,5,2};
    b = new Integer[]{3,0,9,7};
    k = 2;
    kMaxSumCombinations(a,b,k);

    a = new Integer[]{1,4,5,2};
    b = new Integer[]{3,0,9,7};
    k = 3;
    kMaxSumCombinations(a,b,k);*/

    a = new Integer[]{20,19,18,17};
    b = new Integer[]{5,1,0};
    Integer k =4;
    kMaxSumCombinations(a,b,k);

  }
}
