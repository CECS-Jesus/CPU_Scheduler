/**
 * FCFS scheduling algorithm.
 */

import java.util.*;

public class FCFS implements Algorithm {

    private List<Task> queue; // list of tasks passed in from Driver.java
    private Task currentTask; // task to be executed

    // Constructor
    public FCFS(List<Task> queue) {
        this.queue = queue;
    }

    /**
     * First Come First Serve scheduling alorithm
     * Execute each task for a duration of their 
     * burst time before moving on to the next task in the queue.
     * Remove the task from the queue after its execution.
     */
    @Override
    public void schedule() {
        System.out.println("--- First Come First Serve Scheduling ---");

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
     * Return the task at the front of the queue
     */
    @Override
    public Task pickNextTask() {
        return queue.get(0);
    }
}