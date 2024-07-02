package concurrency.problems.quota;


public class QuotaRequest extends BaseRequest {
    QuotaRequest(String id, String client) {
        super(id, client);
    }

    @Override
    public void execute() {
        try {
            System.out.println("Request started " + id + " for client " + client);
            Thread.sleep(2000);
            System.out.println("Request completed " + id + " for client " + client);
        } catch (InterruptedException e) {}
    }
}
