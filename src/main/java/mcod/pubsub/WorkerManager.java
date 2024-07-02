package mcod.pubsub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerManager {
    private ExecutorService executorService;
    private Channel channel;

    WorkerManager(Channel channel) {
        executorService = Executors.newFixedThreadPool(3);
        this.channel = channel;
    }

    public void work() {
        while(true) {
            Request request = channel.get();
            if(request != null) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        request.execute();
                    }
                });
            }
        }
    }

}
