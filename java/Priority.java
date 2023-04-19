/**
 * Priority.java
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;

// Your code here
public class Priority implements Algorithm {
    private List<Task> queue;
    private Task currentTask;

    public Priority(List<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void schedule() {
        System.out.println("\nPriority Scheduling:\n");

        // Sort the tasks by priority (higher priority first)
        Collections.sort(queue, (t1, t2) -> t2.getPriority() - t1.getPriority());

        while (!queue.isEmpty()) {
            currentTask = pickNextTask();
            String currentName = currentTask.getName();
            int currentPri = currentTask.getPriority();
            int currentBurst = currentTask.getBurst();
            int currentTID = currentTask.getTid();
            System.out.println("Now executing: " + currentName + ", TID: " + currentTID + ", Priority: " + currentPri + ", Burst: " + currentBurst);

            // Remove the task from the queue
            queue.remove(currentTask);
            System.out.println("Task " + currentName + " finished.");
        }
    }

    @Override
    public Task pickNextTask() {
        return queue.get(0); // Return the highest priority task in the queue
    }
}
