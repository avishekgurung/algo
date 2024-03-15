package practice;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing thread with Runnable: " + Thread.currentThread().getName());
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Executing thread with Thread: " + Thread.currentThread().getName());
    }
}

class Resource {

    public synchronized void makeThreadWait() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is waiting");
        wait();
        System.out.println(Thread.currentThread().getName() + " is freed");
    }

    public synchronized void freeThread() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is going to free the waiting threads");
        Thread.sleep(1000);
        notify();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " has freed the waiting threads");

    }

}


class SharedResource {

    public void test1() throws InterruptedException{
        synchronized (this) {
            System.out.println("Exec1 started");
            Thread.sleep(5000);
            System.out.println("Exec1 ended");
        }
    }

    public synchronized void test2() {
        System.out.println("Exec2");
    }
}


class MyCallable implements Callable<Integer> {

    public int num1;
    public int num2;

    @Override
    public Integer call() throws Exception {
        return num1 + num2;
    }
}



class Practice {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();
        MyCallable callable = new MyCallable();

        int arr[] = {1,2,3,4,5};
        for(int i=0; i < arr.length; i++) {
            callable.num1 = arr[i];
            callable.num2 = arr[i];
            Future<Integer> future = executorService.submit(callable);
            futures.add(future);
        }

        for(Future<Integer> future : futures) {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}
