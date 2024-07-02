package concurrency.problems.callback;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Service {
    private AsyncChannel asyncChannel;

    public Integer process(Request request) {
        asyncChannel.publish(request);
        return 200;
    }
}
