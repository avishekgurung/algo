package array.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Create a hash where the key is element and the value is a Node that holds the
 * element,freq and first index.
 *
 * Pull the nodes to an array and sort them by freq. But if their freq are same then sort them
 * by index. We use bubble sort below but we should use some better sort algo.
 *
 * Then print each element equal to its freq.
 *
 * Time = O(logn), Space = O(n)
 */
public class Problem068 {

  private class Node {
    int element;
    int freq;
    int index;

    Node(int element, int freq, int index) {
      this.element = element;
      this.freq = freq;
      this.index = index;
    }
  }

  public void sortByFreqMaintainingTheOrder(int arr[]) {
    System.out.println(Arrays.toString(arr));
    Map<Integer, Node> map = new HashMap<Integer, Node>();

    for(int i=0; i < arr.length; i++) {
      if(map.get(arr[i]) == null) {
        map.put(arr[i], new Node(arr[i], 1, i));
      }
      else {
        Node node = map.get(arr[i]);
        node.freq = node.freq + 1;
        map.put(arr[i], node);
      }
    }

    Set<Integer> keys = map.keySet();
    Node nodes[] = new Node[keys.size()];
    int i = 0;
    for(Integer key : keys) {
      nodes[i] = map.get(key);
      i++;
    }


    sort(nodes);
    for(Node node : nodes) {
      int freq = node.freq;
      while(freq != 0) {
        System.out.print(node.element + " ");
        freq--;
      }
    }
    System.out.println("\n");
  }

  /**
   * We should use any other algo with O(nlogn)
   * @param nodes
   */
  public void sort(Node nodes[]) {
    for(int i=0; i < nodes.length - 1; i++) {
      for(int j=i+1; j < nodes.length; j++) {
        if(nodes[i].freq < nodes[j].freq) {
          swap(nodes, i, j);
        }
        else if(nodes[i].freq == nodes[j].freq) {
          if(nodes[i].index > nodes[j].index) {
            swap(nodes, i, j);
          }
        }
      }
    }
  }

  public void swap(Node nodes[], int i, int j) {
    Node temp = nodes[i];
    nodes[i] = nodes[j];
    nodes[j] = temp;
  }


  public static void main(String[] args) {
    Problem068 instance = new Problem068();
    instance.sortByFreqMaintainingTheOrder(new int[]{2, 5, 2, 8, 5, 6, 8, 8});
  }

}
