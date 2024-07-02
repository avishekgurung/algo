package hash;

public class HashMap {
  private class Node {
    int key;
    String value;
    Node next;
    Node(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  int capacity = 5;
  int count = 0;
  Node[] hashTable = new Node[capacity];

  private int hashFunction(int key) {
    Integer wrapper = key;
    return Math.abs(wrapper.hashCode()) % capacity;
  }

  public void put(int key, String value) {
    int index = hashFunction(key);

    if(hashTable[index] == null) {
      hashTable[index] = new Node(key, value);
    }
    else {
      Node pointer = hashTable[index];
      while(pointer.next != null) {
        if(pointer.key == key) {
          pointer.value = value;
          return;
        }
        pointer = pointer.next;
      }
      pointer.next = new Node(key, value);
    }
    count++;
    if(count == (int)(capacity * .8)) resize();
  }

  private void resize() {
    Node[] temp = hashTable;
    capacity = capacity + (int)(capacity * .8);
    count = 0;
    hashTable = new Node[capacity];
    for(Node  node : temp) {
      if(node != null) {
        while(node != null) {
          put(node.key, node.value);
          node = node.next;
        }
      }
    }
  }

  public String get(int key) {
    int index = hashFunction(key);
    Node pointer = hashTable[index];
    if(pointer == null) return null;
    while(pointer != null) {
      if(pointer.key == key) {
        return pointer.value;
      }
      pointer = pointer.next;
    }
    return null;
  }

  public void remove(int key) {
    int index = hashFunction(key);
    Node pointer = hashTable[index];
    if(pointer == null) {
      System.out.println(key + " does not exists");
      return;
    }

    if(pointer.key == key) {
      hashTable[index] = pointer.next;
    }
    else {
      while(pointer.next != null) {
        if(pointer.next.key == key) {
          pointer.next = pointer.next.next;
          return;
        }
        pointer = pointer.next;
      }
    }
  }

  public void hashTableDisplay() {
    int i = 0;
    for(Node node : hashTable) {
      System.out.print(i + "  ");
      while(node != null) {
        System.out.print(node.key + ":" + node.value + " --> ");
        node = node.next;
      }
      System.out.println();
      i++;
    }
  }

  public static void main(String[] args) {
    HashMap map = new HashMap();
    map.put(1, "Avishek");
    map.put(3, "Bibek");
    map.put(6, "Samir");
    map.put(11, "Sovit");
    map.put(10, "SS");
    map.remove(1);
    map.remove(10);
    map.remove(1);

    map.hashTableDisplay();

    System.out.println(map.get(1));
  }

}
