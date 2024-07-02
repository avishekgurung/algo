package concurrency.problems.schedular;

import lombok.Data;

@Data
public class Task {
    private String id;
    private Long executionTime;
    boolean isRepeat;
    private int scheduledTime;

    public Task(String id, Integer scheduledTime, boolean isRepeat) {
        this.isRepeat = isRepeat;
        this.id = id;
        this.executionTime = getTime() + scheduledTime;
        this.scheduledTime = scheduledTime;
    }

    public void execute() {
        System.out.println(getTime() + " : Executing task - " + id);
    }

    private Long getTime() {
        return System.currentTimeMillis() / 1000;
    }
}
