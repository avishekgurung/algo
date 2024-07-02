package dp.classical;

import java.util.*;

public class Problem09 {

  public static void main(String[] args) {
    new Problem09().driver();
  }

  private void driver() {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.remove(1);

  }

  public List<Integer> findSubstring(String s, String[] words) {
    int ws = words[0].length();
    List<String> list = new ArrayList();
    int i=0;
    while(i < s.length()) {
      String aux = s.substring(i, i+ws);
      list.add(aux);
      i = i + ws;
    }
    System.out.println(list);

    List<Integer> indices = new ArrayList();
    for(i=0; i < list.size() - words.length; i++) {
      List<String> ls = Arrays.asList(words);
      for(int j=i; j < i + words.length; j++) {
        String wrd = list.get(j);
        ls.remove(wrd);
      }
      if(ls.isEmpty()) {
        indices.add(i * ws);
      }
    }


    System.out.println(indices);
    return indices;
  }



  private int knapsackBounded(int weight[], int profit[], int index, int weightSum, int profitSum, int W) {
    if(weightSum == W) return profitSum;
    if(weightSum > W ) {
      if(index > 0) return profitSum - profit[index-1];
      else return 0;
    }
    if(index >= weight.length) return 0;
    int result = -1;
    for(int i=index; i < weight.length; i++) {
      result = Math.max(result, knapsackBounded(weight, profit, i+1, weightSum + weight[i], profitSum+profit[i], W));
    }
    return result;
  }
}
