package mcod.pubsub;


import lombok.AllArgsConstructor;

import java.time.LocalTime;
import java.util.Random;

@AllArgsConstructor
public class Request {
    private int id;

    public void execute() {
        //int random = new Random().nextInt(1,3);
        int random = 1;
        try {
            Thread.sleep(random * 1000);
        } catch (InterruptedException e) {}
        System.out.println(LocalTime.now() + " : " + Thread.currentThread().getId()+ " Starting executing request " + id + " with sleep " + random);
    }

}
