package concurrency.problems.callback;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Request {
    private String id;
    private String callbackUrl;

    public void execute() {
        try {
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getId() + ": Completed request: " + id);
        } catch (InterruptedException e) {}
    }

    private void callback() {
        System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getId() + " :Making a callback response for " + id);
    }
}
