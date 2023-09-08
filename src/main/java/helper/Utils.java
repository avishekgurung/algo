package helper;

import java.util.*;

/**
 * @author ~ Avishek Gurung
 */

class HeapNode1 {
    int data;
    int freq;

    HeapNode1(int data, int freq) {
        this.data = data;
        this.freq = freq;
    }

    public int getFreq() {
        return freq;
    }

    @Override
    public String toString() {
        return "Element: " + this.data + ", Freq: " + this.freq;
    }
}

public class Utils {

    public static void main(String args[]) {


        /**
         * Printing array elements.
         */

        System.out.println("Printing arrays.");
        int arr1[] = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(arr1) + "\n");


        /**
         * Printing 2D arrays.
         */
        System.out.println("Printing 2D arrays.");
        int arr2[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.deepToString(arr2) + "\n");


        /**
         * Sorting arrays in ascending order.
         */
        int arr3[] = {3,1,5,2,4};
        Arrays.sort(arr3);
        System.out.println("Sorting arrays.");
        System.out.println(Arrays.toString(arr3) + "\n");


        /**
         * Reversing an array
         */
        Integer arr4[] = {1,2,3,4,5};
        System.out.println("Reversing arrays.");
        Collections.reverse(Arrays.asList(arr4));
        System.out.println(Arrays.toString(arr4));

        /**
         * Using heap (by default)
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(3);
        System.out.println("\nMin heap:");
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.remove());
        }

        /**
         * Max heap.
         */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(4);
        maxHeap.add(2);
        maxHeap.add(3);
        System.out.println("\nMax Heap");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.remove());
        }

        /**
         * Storing objects in heap.
         * Heaps is created as max heap since we are using Collections.reverseOrder()
         */
        System.out.println("\nCustom heap implementation and sorting based on specific attribute.");
        Comparator<HeapNode1> comparator1 = Comparator.comparing(HeapNode1::getFreq, Collections.reverseOrder());
        PriorityQueue<HeapNode1> customHeap = new PriorityQueue<>(comparator1);
        customHeap.add(new HeapNode1(1, 10));
        customHeap.add(new HeapNode1(2, 5));
        customHeap.add(new HeapNode1(3, 7));
        while(!customHeap.isEmpty()) {
            System.out.println(customHeap.remove());
        }

        /**
         * Random number generation.
         */

        System.out.println("\nRandom number generation between two digits.");
        int min = 10;
        int max = 15;
        Random random = new Random();
        for(int i=0; i < 3; i++) {
            System.out.println(random.nextInt(max - min) + min);
        }
    }
}
