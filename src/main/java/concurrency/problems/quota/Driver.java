package concurrency.problems.quota;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static void main(String[] args) throws Exception {
        QuotaFactory quotaFactory = new QuotaFactory();
        RequestManager requestManager = new RequestManager(quotaFactory);
        ClientRegistration clientRegistration = new ClientRegistration(quotaFactory);

        String client1 = "Myntra";
        String client2 = "Flipkart";
        String client3 = "Amazon";

        clientRegistration.register(client1, 2);
        clientRegistration.register(client2, 8);
        clientRegistration.register(client3, 8);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=1; i <= 50; i++) {
            final String client = i % 2 == 0 ? client1 : client2;
            BaseRequest request = new QuotaRequest(i+"", client);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                  requestManager.call(request);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);

    }


}
