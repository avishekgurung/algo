package concurrency.problems.quota;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class QuotaFactory {
    private Map<String, Semaphore> semaphoreMap;

    QuotaFactory() {
        semaphoreMap = new ConcurrentHashMap<>();
    }

    public Semaphore get(String client) {
        if(semaphoreMap.containsKey(client)) return semaphoreMap.get(client);
        return null;
    }

    public void set(String client, int permits) {
        Semaphore semaphore = new Semaphore(permits);
        semaphoreMap.put(client, semaphore);
    }
}
