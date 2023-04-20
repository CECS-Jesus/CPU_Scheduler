/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */
 
import java.util.*;

public class RR implements Algorithm {
    private List<Task> RR_Queue;
    private static final int TIME_QUANTUM = 10; // represent 10 milliseconds

    // Construtor 
    public RR(List<Task> Queue)
    {
        this.RR_Queue = Queue;     
    }

    // "Schedules" all task based on 
    public void schedule()
    {
        System.out.println("Round Robin Scheduling"); 
        // continue running until the list is empty
        while(!RR_Queue.isEmpty()) 
        {
            // task to be scheduled
            Task job = pickNextTask(); 

            // check if all burst equal 0
            int finishedJobs = 0; 
            for(Task x : RR_Queue)
            {
                if(x.getBurst() <= 0)
                {
                    ++finishedJobs;
                }
            }
            if(finishedJobs == RR_Queue.size())
            {
                System.out.println("All tasks have been scheduled :)\n"); 
                return; 
            }

            // check if the Task is finished
            if(job.getBurst() > 0)
            {      
                // subtract time quantum from burst amount
                job.setBurst(job.getBurst() - TIME_QUANTUM);
            } 

            // Print what is being scheduled
            System.out.print("Name:" + job.getName()); // Task Name
            System.out.print(" Tid:" + job.getTid()); // Task Unique Identifier
            System.out.print(" Burst:" + job.getBurst()); // Task Burst amount
            System.out.print(" Priority:" + job.getPriority() + "\n"); // Task Priority

            if (job.getBurst() <= 0)
            {
                System.out.println("Task " + job.getName() + " finished");
            }
        }

    } 

    /*
     * Return the index of the RR_Queue
     */
    public Task pickNextTask()
    {
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