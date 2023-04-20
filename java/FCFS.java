
/**
 * FCFS scheduling algorithm.
 */

import java.util.*;

//Your code here
public class FCFS implements Algorithm {

    private List<Task> queue;
    private Task currentTask;

    public FCFS(List<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void schedule() {
        System.out.println("\nFirst Come First Serve Scheduling:\n");
        while (!queue.isEmpty()) {
            currentTask = pickNextTask();
            String currentName = currentTask.getName();
            int currentPri = currentTask.getPriority();
            int currentBurst = currentTask.getBurst();
            int currentTID = currentTask.getTid();
            System.out.println("Now executing: " + currentName + ", TID: " + currentTID + ", Priority: " + currentPri
                    + ", Burst: " + currentBurst);

            // Remove the task from the queue
            queue.remove(currentTask);
            System.out.println("Task " + currentName + " finished.");
        }
    }

    @Override
    public Task pickNextTask() {
        return queue.get(0);
    }
}
