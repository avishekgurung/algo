package concurrency.problems.schedular;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventLoop implements Runnable{
    private TaskStore taskStore;

    @Override
    public void run() {
        while(true) {
            if(taskStore.peek() != null) {
                if(taskStore.peek().getExecutionTime().toString().equals(getTime().toString())) {
                    execute(taskStore.remove());
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }


    /**
     * For efficient handling, we can push the task to queue and have multiple consumers to process it.
     * @param task
     */
    private void execute(Task task) {
        if(task.isRepeat) {
            task.setExecutionTime(getTime() + task.getScheduledTime());
            taskStore.add(task);
        }
        task.execute();
    }

    private Long getTime() {
        return System.currentTimeMillis() / 1000;
    }
}
