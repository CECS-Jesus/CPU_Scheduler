/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */

import java.util.*;

public class RR implements Algorithm {
    private List<Task> RR_Queue; // list of tasks passed in from Driver.java
    private static final int TIME_QUANTUM = 10; // represent 10 milliseconds

    // Construtor
    public RR(List<Task> Queue) {
        // store a copy of the passed in list
        this.RR_Queue = Queue;
    }

    /**
     * Round Robin algorithm
     * Each task is executed for a certain duration (base on the time quantum) 
     * until the task's burst value is less than or equal to 0
     */
    public void schedule() {
        System.out.println("--- Round Robin Scheduling ---");

        // continue running until the list is empty
        while (!RR_Queue.isEmpty()) {
            // task to be scheduled
            Task job = pickNextTask();

            // check if all burst equal 0
            // exit while loop if all burst equal to 0
            int finishedJobs = 0;
            for (Task x : RR_Queue) {
                if (x.getBurst() <= 0) {
                    ++finishedJobs;
                }
            }
            if (finishedJobs == RR_Queue.size()) {
                System.out.println("All tasks have been scheduled :)\n");
                return;
            }

            // check if the Task is finished
            if (job.getBurst() > 0) {
                // subtract time quantum from burst amount
                job.setBurst(job.getBurst() - TIME_QUANTUM);
            }

            // Display which task is being scheduled
            System.out.print("Execute - ");
            System.out.print("Name:" + job.getName()); // Task Name
            System.out.print(" Tid:" + job.getTid()); // Task Unique Identifier
            System.out.print(" Burst:" + job.getBurst()); // Task Burst amount
            System.out.print(" Priority:" + job.getPriority() + "\n"); // Task Priority

            // Display which job has finished
            if (job.getBurst() <= 0) {
                System.out.println("Task " + job.getName() + " finished");
            }
        }

    }

    /*
     * Return a task to be scheduled based on which task is in the front of the list
     */
    public Task pickNextTask() {
        // safety measure: check if the queue is empty
        if (RR_Queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // Remove the first task in the list
        Task job = RR_Queue.remove(0);

        // Add it to the end of the list
        RR_Queue.add(job);

        return job;
    }
}