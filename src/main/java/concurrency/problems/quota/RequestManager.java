package concurrency.problems.quota;
import lombok.AllArgsConstructor;

import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class RequestManager {
    private QuotaFactory quotaFactory;
    public void call(BaseRequest request) {
        try {
            String client = request.getClient();
            Semaphore semaphore = quotaFactory.get(client);
            semaphore.acquire(); // We can use tryAcquire(60000, TimeUnit.SECONDS) if we want the request to die after 60 seconds.
            request.execute();
            semaphore.release();
        } catch (InterruptedException e) {}
    }
}
