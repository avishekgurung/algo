package heap.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem017 {

  public void printMostOccurredNumbers(int arr[], int k) {
    PriorityQueue maxHeap = new PriorityQueue(k, new ObjComparator());
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i=0; i < arr.length; i++) {
      if(map.get(arr[i]) == null) {
        map.put(arr[i], 1);
      }
      else {
        map.put(arr[i], map.get(arr[i])+1);
      }
    }

    Set<Integer> set = map.keySet();

    for(Integer element : set) {
      int freq = map.get(element);
      Obj obj = new Obj(element, freq);
      maxHeap.add(obj);
    }

    while(k!=0) {
      if(maxHeap.isEmpty()) break;
      Obj obj = (Obj)maxHeap.remove();
      System.out.println(obj.element + "\t" + obj.freq);
      k--;
    }

  }


  private class Obj {
    int element;
    int freq;

    Obj(int element, int freq) {
      this.element = element;
      this.freq = freq;
    }
  }

  private class ObjComparator implements Comparator<Obj> {
    public int compare(Obj o1, Obj o2) {
      if(o1.freq < o2.freq) return 1;
      else if(o1.freq == o2.freq) {
        if(o1.element < o2.element) return 1;
        else return -1;
      }
      else {
        return -1;
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
    int k = 6;
    Problem017 pr = new Problem017();
    pr.printMostOccurredNumbers(arr, k);
  }

}
