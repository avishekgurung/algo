package concurrency.problems.callback;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AsyncChannel {
    private BlockingQueue<Request> queue;

    AsyncChannel() {
        this.queue = new ArrayBlockingQueue(100);
    }

    public synchronized void publish(Request request) {
        queue.add(request);
    }
    public synchronized Request get() {
        if(!queue.isEmpty()) return queue.remove();
        return null;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
