package concurrency.problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Problem03 {

    class Resource {
        AtomicInteger counter = new AtomicInteger(0);
    }

    class Printer implements Runnable {

        private Resource resource;
        private int seqNumber;
        private int number;
        Printer(Resource resource, int seqNumber, int number) {
            this.resource = resource;
            this.seqNumber = seqNumber;
            this.number = number;

            System.out.println("Initiation - " + Thread.currentThread().getId() + " " + seqNumber);
        }

        @Override
        public void run() {
            while(true) {
                try {
                    if(resource.counter.get() % number != seqNumber) {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {}
                System.out.println(Thread.currentThread().getId() + " " + resource.counter.get());
                resource.counter.getAndIncrement();
            }
        }
    }

    private void util() throws InterruptedException{
        int n = 4;
        Resource resource = new Resource();

        /*for(int i=0; i < 4; i++) {
            Thread thread = new Thread(new Printer(resource, i, n));
            thread.start();
        }
*/
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0; i < n; i++) {
            executorService.execute(new Printer(resource, i, n));
        }

    }


    public static void main(String[] args) throws Exception {
        new Problem03().util();
    }
}
