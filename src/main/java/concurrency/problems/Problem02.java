package concurrency.problems;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Problem02 {
    class Resource {

        int n = 11;
        private AtomicInteger number = new AtomicInteger();
        Semaphore semaphore = new Semaphore(1);
        private void print() {

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            int val = get();
                            if(val % 2 != 0) {
                                System.out.println(Thread.currentThread().getId() + " " + number.get());
                                number.getAndIncrement();
                            }
                            semaphore.release();
                            if(val >= n) break;
                        }
                    } catch (Exception e) {}
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            int val = get();
                            if(val % 2 == 0) {
                                System.out.println(Thread.currentThread().getId() + " " + number.get());
                                number.getAndIncrement();
                            }
                            semaphore.release();
                            if(val >= n) break;
                        }
                    } catch (Exception e) {}
                }
            });
            thread2.start();
            thread1.start();
        }

        private int get() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e){}
            return number.get();
        }

    }
    private void util() {
        Resource resource = new Resource();
        resource.print();
    }

    public static void main(String[] args) {
        new Problem02().util();
    }
}
