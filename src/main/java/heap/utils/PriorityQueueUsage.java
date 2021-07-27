/**
 * Created by Avishek Gurung on 2020-12-08
 */

package heap.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueUsage {

    private static void maxHeap() {
        int arr[] = {3,6,8,2,1,0,5};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(arr.length, Collections.reverseOrder());
        for(int i=0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }

        while(!maxHeap.isEmpty()) {
            System.out.print(maxHeap.remove() + " ");
        }
        System.out.println();
    }

    private static void minHeap() {
        int arr[] = {3,6,8,2,1,0,5};
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(arr.length);
        for(int i=0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        while(!minHeap.isEmpty()) {
            System.out.print(minHeap.remove() + " ");
        }
        System.out.println();
    }



    private static void maxHeapWithObject() {
        Comparator<Person> personSorter = Comparator.comparing(Person::getAge, Collections.reverseOrder());
        PriorityQueue<Person> maxHeap = new PriorityQueue<>(personSorter);
        maxHeap.add(new Person("Avishek", 10));
        maxHeap.add(new Person("Sameer", 5));
        maxHeap.add(new Person("Rajeev", 8));

        System.out.println();
        while(!maxHeap.isEmpty()) {
            System.out.println(maxHeap.remove());
        }
        System.out.println();
    }


    private static void minHeapWithObject() {
        Comparator<Person> personSorter = Comparator.comparing(Person::getAge);
        PriorityQueue<Person> maxHeap = new PriorityQueue<>(personSorter);
        maxHeap.add(new Person("Avishek", 10));
        maxHeap.add(new Person("Sameer", 5));
        maxHeap.add(new Person("Rajeev", 8));

        System.out.println();
        while(!maxHeap.isEmpty()) {
            System.out.println(maxHeap.remove());
        }
        System.out.println();
    }


    public static void main(String[] args) {
        maxHeap();
        minHeap();
        maxHeapWithObject();
        minHeapWithObject();
    }


}

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.age;
    }
}
