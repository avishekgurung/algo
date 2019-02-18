package heap.utils;

/**
 * The elements in heap are maintained in an array. The main objective of heap is that
 * when we call remove() then it has to remove the largest element. The array that we
 * use internally for storing the elements always has the highest element on its 0 index.
 * Every other elements in an array are arranged in such a way that for a given element
 * at index i, its parent is at (i-1)/2, left child is at 2*i+1 and right child at 2*i+2.
 *
 * The theoretical properties of heap:
 * 1. A tree where a node is always higher than its children.
 * 2. All leaves are at height h or h-1
 *
 * We use array internally to implement a heap.
 */
public class MaxHeap {

  private int count;
  private int arr[];
  private int size; //capacity

  MaxHeap() {
    count = 0;
    size = 4; //Java's initial heap size
    arr = new int[size];
  }

  /**
   * Inserting element into heap.
   * Time Complexity: O(logn).
   * @param data
   *
   * (i-1)/2 gives a parent of i in the array.
   * We start comparing with the last element of an array with the element to insert and
   * keep moving to the left until we find a suitable place to insert the element.
   *
   */
  public void add(int data) {
    if(count >= arr.length) resize();
    int i = count;
    while(i > 0 && data > arr[(i-1)/2]) {
      arr[i] = arr[(i-1)/2];
      i = (i-1)/2;
    }
    arr[i] = data;
    count++;
  }

  private void resize() {
    int newSize = size + 11;
    int newArr[] = new int[newSize];
    for(int i=0; i < arr.length; i++) {
      newArr[i] = arr[i];
    }
    size = newSize;
    arr = newArr;
  }

  /**
   * Fetches the parent for a given element based on the index.
   * @param i
   * @return
   */
  private int getParent(int i) {
    int parent = (i-1)/2;
    if(i < 0) parent = -1;
    return parent;
  }

  /**
   * Fetches the left child of an element based on the index.
   * @param i
   * @return
   */
  private int getLeftChild(int i) {
    int left = 2 * i + 1;
    if(left >= count) left = -1;
    return left;
  }

  /**
   * Fetches the right child of an element based on the index.
   * @param i
   * @return
   */
  private int getRightChild(int i) {
    int right = 2 * i + 2;
    if(right >= count) right = -1;
    return right;
  }

  /**
   * Top element (or arr[0]) holds the max element. When we remove the max element, we
   * bring the last element of an array into 0 index and move it down the tree so that
   * it goes to the correct position.
   * Remember that this last element is not the smallest element in Max Heap, because
   * the elements in arr are not sorted in descending order, its just that the first
   * element of an array has max value.
   *
   * Exp: if(leftChild == -1 && rightChild == -1) return;
   * Hence in percolate down, we move the last element of an array to its front and
   * start moving downward in the array until the element finds a suitable position.
   * While moving down if its left child and right child is -1 then this means the
   * element cannot go further down the array (mean it is a leaf) so the element has
   * reached its correct position in an array.
   *
   * Exp: if(max == i) return;
   * If the value of index i is higher than its left child and right child,
   * then it need not go down further and it has found its right position satisfying the
   * heap property.
   *
   * Otherwise, we will replace the current index by the maximum of two children. Giving
   * first preference to left child.
   * As we see, we do the swap. The max now contains the original value which is yet
   * to find its place and we percolate down.
   *
   * @param i
   * Time Complexity: logn because the child search is moving by 2 units.
   */
  private void percolateDown(int i) {
    int leftChild = getLeftChild(i);
    int rightChild = getRightChild(i);
    if(leftChild == -1 && rightChild == -1) return;

    int max;
    if(leftChild != -1 && arr[leftChild] > arr[i]) {
      max = leftChild;
    }
    else {
      max = i;
    }

    if(rightChild != -1 && arr[rightChild] > arr[max]) {
      max = rightChild;
    }

    if(max == i) {
      return;
    }
    else {
      int temp = arr[max];
      arr[max] = arr[i];
      arr[i] = temp;
    }
    percolateDown(max);
  }

  public int peek() {
    return arr[0];
  }

  public boolean isEmpty() {
    return count == 0 ? true : false;
  }

  /**
   * Removing single element take logn.
   * Removing all the elements takes nlogn.
   * @return
   * @throws Exception
   */
  public int remove() throws Exception{
    if(count == 0) throw new Exception("Heap is empty");
    int data = arr[0];
    count--;
    arr[0] = arr[count];
    percolateDown(0);
    return data;
  }

  /**
   * This method will have its use when we want to keep complexities to minimum.
   * @param dataToInsert
   * @return
   */
  public int removeAndReplace(int dataToInsert) {
    int dataToRemove = arr[0];
    arr[0] = dataToInsert;
    percolateDown(0);
    return dataToRemove;
  }

  public static void main(String[] args) throws Exception{
    MaxHeap heap = new MaxHeap();
    heap.add(3);
    heap.add(5);
    heap.add(1);
    heap.add(7);
    heap.add(4);
    heap.add(9);
    heap.add(6);
    heap.add(0);
    heap.add(10);
    heap.add(2);

    while(!heap.isEmpty()) {
      System.out.println(heap.remove());
    }
  }
}
