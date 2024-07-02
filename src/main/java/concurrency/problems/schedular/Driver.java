package concurrency.problems.schedular;

public class Driver {
    public static void main(String[] args) {
        TaskStore taskStore = new TaskStore();
        Schedular schedular = new Schedular(taskStore);
        EventLoop eventLoop = new EventLoop(taskStore);

        Task t1 = new Task("1", 5, true);
        schedular.schedule(t1);

        eventLoop.run();
    }
}
