package mcod.pubsub;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Publisher {

    private Channel channel;

    public void publish() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while(true) {
                    //int random = new Random().nextInt(1,3);
                    int random = 1;
                    Request request = new Request(i);
                    i++;
                    channel.add(request);
                    try {
                        Thread.sleep(random * 100);
                    } catch (InterruptedException e) {}
                }
            }
        });

        thread.start();
    }


}
