package mcod.pubsub;


import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        //int random = new Random().nextInt(1,3);
        //System.out.println(random);
        Channel channel = new Channel();
        Publisher publisher = new Publisher(channel);
        WorkerManager workerManager = new WorkerManager(channel);

        publisher.publish();
        workerManager.work();
    }
}
