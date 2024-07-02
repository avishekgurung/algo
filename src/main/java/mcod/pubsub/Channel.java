package mcod.pubsub;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Channel {
    private BlockingQueue<Request> queue;
    Channel() {
        queue = new ArrayBlockingQueue<>(1000);
    }

    public void add(Request request) {
        queue.add(request);
    }

    public Request get() {
        if(!queue.isEmpty()) return queue.remove();
        return null;
    }

}
