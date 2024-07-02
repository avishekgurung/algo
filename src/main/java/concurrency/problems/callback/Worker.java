package concurrency.problems.callback;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Worker implements Runnable {
    private Request request;
    public void run() {
        request.execute();
    }

}
