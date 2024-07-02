package concurrency.problems.schedular;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskStore {

    class TaskComparator implements Comparator<Task> {
        public int compare(Task t1, Task t2) {
            if(t1.getExecutionTime() < t2.getExecutionTime()) return 1;
            else return -1;
        }
    }
    private PriorityBlockingQueue<Task> heap;
    TaskStore() {
        heap = new PriorityBlockingQueue(100, new TaskComparator());
    }
    public synchronized void add(Task task) {
        heap.add(task);
    }

    public synchronized Task remove() {
        if(!heap.isEmpty()) return heap.remove();
        return null;
    }

    public synchronized Task peek() {
        if(!heap.isEmpty()) {
            return heap.peek();
        }
        return null;
    }

    public synchronized int size() {
        return heap.size();
    }
}
