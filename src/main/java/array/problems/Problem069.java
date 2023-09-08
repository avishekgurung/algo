package array.problems;


import java.util.*;

/**
 * My approach.
 * Given an array = [3,4,1,5,2]
 * Create another sorted array for this which is 1,2,3,4,5.
 * So we have two arrays now
 *  [3,4,1,5,2]
 *  [1,2,3,4,5]
 *
 *  Compare each element at ith index,
 *  if they are same then do nothing,
 *  else swap them,
 *  Eg, at i=0, 3 != 1, so we swap 3 with 1 in 1st array.
 *  [1,4,3,5,2]
 *  [1,2,3,4,5]
 *
 *  Now the the second index, i=1. 4 != 2 so we swap 4 with 2.
 *  [1,2,3,5,4]
 *  [1,2,3,4,5]
 *  at i = 2, 3 == 3 so no need to swap.
 *
 *  at i= 3, again swap, which gives us
 *  [1,2,3,4,5] which is sorted as well.
 *
 * Time complexity = O(logn) for sorting the array and space  = O(n)
 *
 * This might not solve all the edge cases.
 *
 * Start from the last element and perform insertion sort and check after every sort if the
 * arrays are sorted. (Verify if this works)
 *
 * Or
 *
 * start from the last element, let i be the last element index.
 * find largest element from 0 to i-1.
 * If this largest element is > arr[i], then we need to swap.
 * So we shift this largest element to the end oor we might perform an insertion sort too.
 *
 */
public class Problem069 {

  public static void minimumNumberOfSwapsToSortArray(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int[] sorted = arr.clone();
    Arrays.sort(sorted);
    int minSwap = 0;

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i=0; i < arr.length; i++) map.put(arr[i], i);

    for(int i=0; i < arr.length; i++) {
      if(arr[i] == sorted[i]) continue;
      swap(arr, i, map.get(sorted[i]));
      minSwap++;
    }

    System.out.println("The minimum swap required is " + minSwap + "\n");
  }

  private static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    minimumNumberOfSwapsToSortArray(new int[]{1,2,3,4,5});
    minimumNumberOfSwapsToSortArray(new int[]{4, 3, 2, 1});
    //altSolution(new int[]{1, 5, 4, 3, 2});
    minimumNumberOfSwapsToSortArray(new int[]{6, 5, 2, 7, 4, 1, 3});
  }

  /**
   * A simple and easy approach. Start from the first element. Now find the smallest element to its right. If the element
   * exists then swap it, if not move forward. The complexity will n2 if the elements are sorted in reverse order.
   *
   * We will use extra space to optimise time complexity. We will put all the elements in min heap. We will also
   * maintain a set to check if the element has been traversed. This will be useful discard the elements from heap that
   * is already processed. We will see better clarity in the example.
   *
   * The time complexity will be nlogn since for each removal from heap, we are heapifying the element.
   * The space complexity will O(n).
   */


  private static void altSolution(int arr[]) {
    Comparator<MyNode> comparator = Comparator.comparing(MyNode::getElement);
    PriorityQueue<MyNode> minHeap = new PriorityQueue<>(comparator);
    for(int i=0; i < arr.length; i++) {
      MyNode myNode = new MyNode(arr[i], i);
      minHeap.add(myNode);
    }
    Set<Integer> traversed = new HashSet<>();

    int steps = 0;

    for(int i=0; i < arr.length; i++) {
      if(!minHeap.isEmpty() && arr[i] > minHeap.peek().element) {
        while(true) {
          MyNode top = minHeap.remove();
          if(traversed.contains(top.element)) {
            continue;
          }
          int aux = arr[i];
          arr[i] = arr[top.index];
          arr[top.index] = aux;
          traversed.add(arr[i]);
          steps++;
        }
       }
      else {
        traversed.add(arr[i]);
      }
    }
    System.out.println(Arrays.toString(arr));
    System.out.println("Steps: " + steps);
  }
}

class MyNode {
  int element;
  int index;

  MyNode(int element, int index) {
    this.element = element;
    this.index = index;
  }

  public int getElement() {
    return element;
  }
}


