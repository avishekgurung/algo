package heap.utils;

public class MinHeap {

  private int size;
  private int arr[];
  private int count;

  MinHeap() {
    size = 10;
    arr = new int[size];
    count = 0;
  }

  public void add(int data) {
    int i = count;
    while(i > 0 && data < arr[(i-1)/2]) {
      arr[i] = arr[(i-1)/2];
      i = (i-1)/2;
    }
    arr[i] = data;
    count++;
  }

  private int getLeftChild(int i) {
    int leftChild = 2 * i + 1;
    if(leftChild >= count) leftChild = -1;
    return leftChild;
  }

  private int getRightChild(int i) {
    int rightChild = 2 * i + 2;
    if(rightChild >= count) rightChild = -1;
    return rightChild;
  }

  private void percolateDown(int i) {
    int leftChild = getLeftChild(i);
    int rightChild = getRightChild(i);
    if(leftChild == -1 && rightChild == -1) return;

    int min;

    if(leftChild != -1 && arr[leftChild] < arr[i]) {
      min = leftChild;
    }
    else {
      min = i;
    }

    if(rightChild != -1 && arr[rightChild] < arr[min]) {
      min = rightChild;
    }

    if(min != i) {
      int temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }
    else {
      return;
    }
    percolateDown(min);
  }

  public boolean isEmpty() {
    return count == 0 ? true : false;
  }

  public int remove() throws Exception {
    if(count == 0) throw new Exception("Heap is empty");
    count--;
    int data = arr[0];
    arr[0] = arr[count];
    percolateDown(0);
    return data;
  }

  public static void main(String[] args) throws Exception{
    MinHeap heap = new MinHeap();
    heap.add(5);
    heap.add(8);
    heap.add(2);
    heap.add(9);
    heap.add(18);
    heap.add(2);
    heap.add(7);

    while(!heap.isEmpty()) {
      System.out.println(heap.remove());
    }
  }

}
