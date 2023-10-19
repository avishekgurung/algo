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

class HeapNodeComparator implements Comparator<HeapNode1> {

    /**
     * We will sort the nodes based on increasing data, i.e. The heap node will be minHeap based on the value of data.
     * But in cases, where the data value are same, then higher freq will take precedence.
     *
     * We can think of compare function working as , if the first object o1's attribute > o2's attribute and if it
     * returns 1, then they are sorted in increasing order.
     */

    @Override
    public int compare(HeapNode1 o1, HeapNode1 o2) {
        if(o1.data > o2.data) {
            return 1;
        } else if(o1.data < o2.data) {
            return -1;
        } else {
            if(o1.freq > o2.freq) {
                return -1;
            }
            else {
                return 1;
            }
        }
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
         * Storing objects in heap and sorting the nodes by one attribute.
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
         * Storing the object in heap and sorting them by one attribute. But of the attributes are different then
         * sorting them by another attribute.
         */

        System.out.println("\nCustom heap implementation and sorting based on more than one attributes");
        HeapNodeComparator heapNodeComparator = new HeapNodeComparator();
        PriorityQueue<HeapNode1> customHeap1 = new PriorityQueue<>(heapNodeComparator);
        customHeap1.add(new HeapNode1(4, 2));
        customHeap1.add(new HeapNode1(2, 5));
        customHeap1.add(new HeapNode1(2, 1));
        customHeap1.add(new HeapNode1(2, 8));
        while(!customHeap1.isEmpty()) {
            System.out.println(customHeap1.remove());
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

        /**
         * Sorting a 2D array by a specific colum
         */
        int points[][] = {{10,16},{2,8},{1,6},{7,12}};
        for(int i=0; i < points.length; i++) System.out.print(Arrays.toString(points[i]));
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                if(entry1[1] > entry2[1]) return 1;
                else return -1;
            }
        });
        System.out.println();
        for(int i=0; i < points.length; i++) System.out.print(Arrays.toString(points[i]));


        /**
         * Sorting a String
         */
        String str = "badec";
        char chars[] = str.toCharArray();
        Arrays.toString(chars);
        String sorted = new String(chars);
        System.out.println(sorted);

    }
}
