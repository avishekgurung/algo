package heap.problems;

/**
 * The solution that comes in my mind is sorted doubly linked list.
 *
 *  1 <-> 3 <-> 4  <-> 6  <-> 8  <-> 10
 *
 *  FindMin() will always be the first element so O(1)
 *
 *  FindMax() will always be the last element so  O(1)
 *
 *  DeleteMin() will involve removing the first element and pointer shift, so O(1)
 *
 *  DeleteMax() will involve removing the last element and pointer shift, so O(1)
 *
 *  Insert() will involve searching the whole list so O(n) and since insert is
 *  least frequent so we can afford it.
 *
 *  Delete() also involves searching the whole list so O(n) and since delete is
 *  least frequent so we can afford it.
 *
 *
 */
public class Problem010 {
}
