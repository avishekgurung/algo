package concurrency.problems.callback;

public class Driver {
    public static void main(String[] args) throws Exception {
        AsyncChannel asyncChannel = new AsyncChannel();
        WorkerManager workerManager = new WorkerManager(asyncChannel);
        Service service = new Service(asyncChannel);

        for(int i=1; i < 20; i++) {
            Request request = new Request(i+"", "www.abcd.com");
            service.process(request);
        }
        workerManager.initiate();
    }
}
