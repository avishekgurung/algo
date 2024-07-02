package hash;

/**
 * This is a Hash implementation and not a HashMap so we do have a key,value pair. Its same as
 * set in Java where the insertion, deletion and fetching time is O(1).
 *
 * The collision resolution technique used is Separate Chaining which involves using linked list.
 * The similar implementation can be used while creating hashMap as well.
 *
 * To implement it as Map we just add one more attribute in the Node which will be the value.
 */
public class HashWithSeparateChaining {

  private class Node {
    String data;
    Node next;
    Node(String data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  int capacity;
  int count;
  Node[] hashTable;

  HashWithSeparateChaining() {
    capacity = 10;
    count = 0;
    hashTable = new Node[capacity];
  }

  public int hashFunction(String key) {
    return Math.abs(key.hashCode()) % capacity;
  }


  public void add(String item) {
    count++;
    int index = hashFunction(item);
    if(hashTable[index] == null) {
      hashTable[index] = new Node(item, null);
    }
    else {
      Node pointer = hashTable[index];
      while(pointer.next != null) {
        if(pointer.data.equals(item)) return;
        pointer = pointer.next;
      }
      pointer.next = new Node(item, null);
    }
    if(count > (int)(capacity * .75)) {
      resize();
    }
  }

  public boolean contains(String item) {
    int index = hashFunction(item);
    Node pointer = hashTable[index];
    while(pointer != null) {
      if(pointer.data.equals(item)) {
        return true;
      }
      pointer = pointer.next;
    }
    return false;
  }

  public void remove(String item) {
    int index = hashFunction(item);
    if(hashTable[index] == null) {
      System.out.println(item + " is not present in the set");
      return;
    }
    Node pointer = hashTable[index];

    //Deleting first element
    if(hashTable[index].data.equals(item)) {
      hashTable[index] = hashTable[index].next;
      return;
    }

    //Deleting element in the middle
    while(pointer.next!= null) {
      if(pointer.next.data.equals(item)) {
        pointer.next = pointer.next.next;
      }
    }
  }

  private void resize() {
    count = 0;
    capacity = 2 * capacity;
    Node[] temp = hashTable;
    hashTable = new Node[capacity];

    for(Node pointer : temp) {
      while(pointer != null) {
        String item = pointer.data;
        add(item);
        pointer = pointer.next;
      }
    }
  }

  public void viewHashTable() {
    for(int i=0; i < hashTable.length; i++) {
      Node pointer = hashTable[i];
      System.out.print(i + " : ");
      while(pointer != null) {
        System.out.print(pointer.data + " -> ");
        pointer = pointer.next;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    HashWithSeparateChaining set = new HashWithSeparateChaining();
    set.add("AB");
    set.add("B");
    set.add("C");
    set.add("D");
    set.add("BA");
    set.viewHashTable();
    System.out.println(set.contains("AB"));
    System.out.println(set.contains("BA"));
    System.out.println(set.contains("DE"));
    set.remove("AB");
    set.viewHashTable();
    set.remove("B");
    set.viewHashTable();
    set.remove("BA");
    set.viewHashTable();
  }

}
