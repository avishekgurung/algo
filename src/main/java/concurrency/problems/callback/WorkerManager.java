package concurrency.problems.callback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerManager {
    private ExecutorService executorService;
    private AsyncChannel asyncChannel;

    WorkerManager(AsyncChannel asyncChannel) {
        executorService = Executors.newFixedThreadPool(3);
        this.asyncChannel = asyncChannel;

    }

    public void initiate() throws InterruptedException {
        while(!asyncChannel.isEmpty()) {
            final Request request = asyncChannel.get();
            executorService.submit(new Worker(request));
        }
        executorService.shutdown();
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
    }
}
