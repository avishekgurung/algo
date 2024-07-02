package concurrency.problems.schedular;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Schedular {
    private TaskStore taskStore;

    public void schedule(Task task) {
        System.out.println(getTime() + " : Submitting task " + task.getId());
        taskStore.add(task);
    }

    private Long getTime() {
        return System.currentTimeMillis() / 1000;
    }
}
