/**
 * Priority.java
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;

public class Priority implements Algorithm {
    private List<Task> queue; // list of tasks passed in from Driver.java
    private Task currentTask; // task to be executed 

    // Constructor
    public Priority(List<Task> queue) {
        this.queue = queue;
    }

    /**
     * Priority based scheduling algorithm.
     * A sorting alorithm was used to sort the list of tasks
     * based on priority number. After sorting, execute the list of tasks.
     */
    @Override
    public void schedule() {
        System.out.println("--- Priority Scheduling ---");

        // Sort the tasks by priority (higher priority first)
        Collections.sort(queue, (t1, t2) -> t2.getPriority() - t1.getPriority());

        while (!queue.isEmpty()) 
        {
            currentTask = pickNextTask();
            String currentName = currentTask.getName();
            int currentPri = currentTask.getPriority();
            int currentBurst = currentTask.getBurst();
            int currentTID = currentTask.getTid();

            // Display which task is being scheduled
            System.out.print("Executing - ");
            System.out.print("Name:" + currentName);
            System.out.print(" TID:" + currentTID);
            System.out.print(" Priority:" + currentPri);
            System.out.print(" Burst:" + currentBurst);

            // Remove the task from the queue
            queue.remove(currentTask);
            System.out.println("Task " + currentName + " finished");
        }

        System.out.println("All tasks have been scheduled :)\n");
    }

    /**
     * Return the highest priority task in the queue
     */
    @Override
    public Task pickNextTask() {
        return queue.get(0); 
    }
}
