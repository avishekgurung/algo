package stacks.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem016 {

  private class Item {
    String name;
    int value;

    Item(String name, int value) {
      this.name = name;
      this.value = value;
    }
  }

  private class ItemComparator implements Comparator <Item> {
    public int compare(Item o1, Item o2) {
      if(o1.value < o2.value) return 1;
      else if(o1.value > o2.value) return -1;
      else return 0;
    }
  }

  private class Stack {
    PriorityQueue<Item> heap;
    private int priority;
    Stack() {
      priority = 1;
      heap = new PriorityQueue<Item>(5, new ItemComparator());
    }

    public void push(String name) {
      heap.add(new Item(name, priority++));
    }

    public String pop() {
      priority--;
      return heap.poll().name;
    }

    public boolean isEmpty() {
      return heap.isEmpty();
    }
  }

  public void utility() {
    Stack stack = new Stack();
    stack.push("A");
    stack.push("B");
    stack.push("C");
    System.out.println(stack.pop());
    stack.push("D");
    stack.push("E");
    System.out.println(stack.pop());
    stack.push("F");
    stack.push("G");
    System.out.println();
    while(!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  public static void main(String[] args) {
    new Problem016().utility();
  }
}

/**
 * Implementation details:
 *
 * We know that heap sorts elements internally based on priority. So for every given element
 * we keep increasing the priority so that the latest element inserted is at the top of the heap.
 *
 * Another approach is, lets say we are given only numbers. Then heap always gives us
 * the min element when removed (min heap). So every time, we insert an element into the
 * heap, it should always be higher than the top element of the heap.
 * So we can perform the following operations.
 *
 * push(int item)
 * heap.insert(item + heap.peek())
 *
 * pop()
 * x = heap.remove()
 * int item = x - heap.peek()
 * return item
 *
 */
