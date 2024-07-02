package concurrency.problems.quota;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClientRegistration {
    private QuotaFactory quotaFactory;

    public void register(String client, int permits) {
        quotaFactory.set(client, permits);
    }
}
