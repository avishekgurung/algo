package hash.impl;

/**
 * This is a Hash implementation and not a HashMap so we do have a key,value pair. Its same as
 * set in Java where the insertion, deletion and fetching time is O(1).
 *
 * The collision resolution technique used is Linear Probing. We do not use linked list here. If
 * the collision occurs then we seek for next empty place. If all the places are occupied till the
 * end of an array then we go to beginning of an array and start searching for an empty place.
 *
 * For searching the data, we find the location(index) of an item by hash function. We fetch the
 * item from that location and check if it matches the given item. If yes we return. Else we keep
 * traversing in search of an item. If an item is not found till the end, we go to the beginning
 * of the list and start searching until we reach the same item from where we had started.
 *
 * To implement as map, we need to use two array, one for storing the key (which will act as
 * hashtable) and other for storing the values.
 *
 * Incase of collision, the adding and searching can be long and can take O(n).
 */
public class HashWithLinearProbing {
  
  int count = 0;
  int capacity = 5;
  int hashTable[] = new int[capacity];
  
  
  private int hashFunction(int key) {
    Integer keyWrapper = key;
    return Math.abs(keyWrapper.hashCode()) % capacity;
  }
  
  public void add(int item) {
    int index = hashFunction(item);
    insertWithLinearProbing(item, index);
    count++;
    if(count == (int)(capacity * .75)) resize();
  }

  private void resize() {
    int temp[] = hashTable;
    capacity = capacity + (int)(capacity * .75);
    hashTable = new int[capacity];
    count = 0;

    for(int i=0; i < temp.length; i++) {
      if(temp[i] != 0) {
        add(temp[i]);
      }
    }

  }

  private void insertWithLinearProbing(int item, int index) {
    if(hashTable[index] == item) return;
    if(hashTable[index] == 0) {
      hashTable[index] = item;
      return;
    }
    insertWithLinearProbing(item, (index + 1) % capacity);
  }
  
  public boolean contains(int item) {
    int index = hashFunction(item);
    return searchWithLinearProbing(item, index,  index);
  }
  
  private boolean searchWithLinearProbing(int item, int index, int initialIndex) {
    if(hashTable[index] == item) return true;
    if(index + 1 == initialIndex) return false;
    return searchWithLinearProbing(item, (index + 1)%capacity, initialIndex);
  }

  public boolean remove(int item) {
    int index = hashFunction(item);
    return removeWithLinearProbing(item, index, index);
  }

  public boolean removeWithLinearProbing(int item, int index, int initialIndex) {
    if(hashTable[index] == item) {
      hashTable[index] = 0;
      return true;
    }
    if(index + 1 == initialIndex) return false;
    return removeWithLinearProbing(item, (index + 1) % capacity, initialIndex);
  }

  public void hashTableDispaly() {
    for(int i=0; i < capacity; i++) {
      System.out.println(i + " : " + hashTable[i]);
    }
  }

  public static void main(String[] args) {
    HashWithLinearProbing set = new HashWithLinearProbing();
    set.add(3);
    set.add(8);

    set.hashTableDispaly();
    System.out.println(set.remove(3));
    set.hashTableDispaly();
    System.out.println(set.remove(18));
    set.hashTableDispaly();
  }
  
}
