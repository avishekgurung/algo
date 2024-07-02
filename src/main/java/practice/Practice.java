package practice;



import lombok.AllArgsConstructor;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * There are different approaches to solve the problem
 *
 * 1. Naive
 *  a. Perform a combination of a given string.
 *  b. For a combination of size t, find all the permutation and compare it with the dictionary.
 *
 * 2. We can iterate the characters of every word in a dictionary and check if these characters appear in the given
 * word.
 *
 * 3. We will sort the given word and find a combination of size t. We will iterate every word of dictionary, sort the
 * word and compare it with the combination obtained above.
 */
class Practice {

    class Resource {

        Semaphore semaphore = new Semaphore(1);

        public void critical() throws InterruptedException {
            System.out.println(System.currentTimeMillis() / 1000 + ": " + Thread.currentThread().getId() + " Entered -1");
            //semaphore.acquire();
            semaphore.tryAcquire(2, TimeUnit.SECONDS);
            //Thread.sleep(3000);
            System.out.println(System.currentTimeMillis() / 1000 + ": " + Thread.currentThread().getId() + " Released -2");
        }


        public void release() throws InterruptedException {
            Thread.sleep(5000);
            semaphore.release();
        }

    }

    public static void main(String[] args) throws Exception {
        new Practice().driver();
    }

    @AllArgsConstructor
    class MyThread implements Runnable {
        Resource resource;

        @Override
        public void run() {
            try {
                resource.critical();
                //Thread.sleep(3000);
                resource.release();
            } catch (InterruptedException e) {}
        }
    }
    private void driver() throws InterruptedException {

        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
        Date date1 = new Date(2023, 02, 24, 00, 00, 10);
        System.out.println(date1);
        System.out.println(date1.getTime());
    }



    class FizzBuzz {
        private int n;

        private Object obj = new Object();
        AtomicInteger counter = new AtomicInteger(1);

        Semaphore semaphore = new Semaphore(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while(true) {
                int val = get();
                if(val > n) {
                    semaphore.release();
                    break;
                }
                if(val % 3 == 0 && val % 5 != 0) {
                    System.out.print("Fizz ");
                    counter.incrementAndGet();
                }
                semaphore.release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while(true) {
                int val = get();
                if(val > n) {
                    semaphore.release();
                    break;
                }
                //System.out.println(val);
                if(val % 3 != 0 && val % 5 == 0) {
                    //System.out.println(counter.get());
                    System.out.print("Buzz ");
                    counter.incrementAndGet();
                }
                semaphore.release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while(true) {
                int val = get();
                if(val > n){
                    semaphore.release();
                    break;
                }
                if(val % 3 == 0 && val % 5 == 0) {
                    System.out.print("FizzBuzz ");
                    counter.incrementAndGet();
                }
                semaphore.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while(true) {
                int val = get();
                if(val > n) {
                    semaphore.release();
                    break;
                }
                if(val % 3 != 0 && val % 5 != 0) {
                    //printNumber.accept(counter.get());
                    System.out.print(val+ " ");
                    counter.incrementAndGet();
                }
                semaphore.release();
            }
        }

        private int get() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {}
            return counter.get();
        }
    }










}

