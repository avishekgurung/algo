package heap.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem014 {

  public static int getMaxDistinctElements(int arr[], int k) {
    int distinct = 0;
    Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    for(int i=0; i < arr.length; i++) {
      if(freqMap.get(arr[i]) == null) {
        freqMap.put(arr[i], 1);
      }
      else {
        freqMap.put(arr[i], freqMap.get(arr[i]) +1 );
      }
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    Set<Integer> keys = freqMap.keySet();
    for(Integer ele : keys) {
      minHeap.add(freqMap.get(ele));
    }

    while(!minHeap.isEmpty()) {
      int freq = minHeap.remove();
      if(freq == 1) {
        distinct++;
      }
      else if(freq > 1 && k > 0) {
        int x = freq - 1;
        k = k - x;
        if(k >=0) distinct++;
      }
    }
    return distinct;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{5, 7, 5, 5, 1, 1, 2, 2, 5};
    int k = 5;
    System.out.println(Arrays.toString(arr));
    System.out.println("k = " + k);
    System.out.println("distinct: " + getMaxDistinctElements(arr,k ));

    System.out.println();
    k = 4;
    System.out.println("k = " + k);
    System.out.println("distinct: " + getMaxDistinctElements(arr,k ));

    System.out.println();
    k = 3;
    System.out.println("k = " + k);
    System.out.println("distinct: " + getMaxDistinctElements(arr,k ));

    System.out.println();
    k = 2;
    System.out.println("k = " + k);
    System.out.println("distinct: " + getMaxDistinctElements(arr,k ));

    System.out.println();
    k = 1;
    System.out.println("k = " + k);
    System.out.println("distinct: " + getMaxDistinctElements(arr,k ));

    System.out.println();
    k = 0;
    System.out.println("k = " + k);
    System.out.println("distinct: " + getMaxDistinctElements(arr,k ));

    System.out.println();
    k = 100;
    System.out.println("k = " + k);
    System.out.println("distinct: " + getMaxDistinctElements(arr,k ));
  }

}
