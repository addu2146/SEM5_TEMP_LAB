#include <stdio.h>
//#include<brain.addu2146>>
// Non-preemptive FCFS 
typedef struct {
    int pnum;  // Process ID
    int at;    // Arrival time
    int bt;    // Burst time
} Process;

int wt = 0;  //  waiting time fpr some process
int tt = 0;  //  turnaround time for some process
int total_wt = 0;  // Total waiting time for all processes
int total_tt = 0;  // Total turnaround time

#define SIZE 20
Process ReadyQueue[SIZE];
int front = 0;
int back = 0;

void enque(Process p);
Process deque();
Process SelectforEnque(Process p[], int num_Processes);
void execute(int num_processes);

int main() {
     
    printf("21462       21462       21462      21462\n");
    printf("1           1           1          1    \n");
    printf("46214       4           46214      46214\n");
    printf("6           6           6              6\n");
    printf("2           21462       2          21462\n");
    
    
    printf("\n\n\n"); 
    
    int num_processes;
    printf("Enter The Number of Processes You Want to Get executed\n");
    scanf("%d", &num_processes);

    // Initialize an array to store processes
    Process Batch[num_processes];
    
    // Get process details
    int i;
    for ( i = 0; i < num_processes; i++) {
        printf("Enter the arrival time and burst time of Process %d:\n", i + 1);
        scanf("%d%d", &Batch[i].at, &Batch[i].bt);
        Batch[i].pnum = i + 1;  // Assign process ID
    }
    
    // Select and enqueue processes based on FCFS
    while (num_processes > 0) {
        Process selected_p = SelectforEnque(Batch, num_processes);
        enque(selected_p);
        
        // Remove the enqueued process from the Batch
        int indexToRemove = -1;
        int j;
        for ( j = 0; j < num_processes; j++) {
            if (Batch[j].pnum == selected_p.pnum) {
                indexToRemove = j;
                break;
            }
        }
        int k;
        // Shift processes to remove the selected one
        for ( k = indexToRemove; k < num_processes - 1; k++) {
            Batch[k] = Batch[k + 1];
        }
        num_processes--; //decrease the sizeof array
    }
    
    // Execute the processes in FCFS order and calculate times
    execute(back);
    getchar();
}

Process SelectforEnque(Process p[], int num_Processes) {
    Process First_Process = p[0];
    int i;
    
    for ( i = 1; i < num_Processes; i++) {
        if (p[i].at < First_Process.at) {
            First_Process = p[i];  // Select the process with the earliest arrival time
        }
    }
    
    return First_Process;
}

void enque(Process p) {
    if (back == SIZE) {
        printf("ReadyQueue is full, wait for a process to complete\n");
    } else {
        ReadyQueue[back++] = p;  // Insert process in the queue
        printf("Process %d was fetched to the Ready queue\n", p.pnum);
    }
}

Process deque() {
    if (front == back) {
        printf("ALL PROCESSES COMPLETE\n");
        Process empty = {0, 0, 0};
        return empty;  // Return an empty process if the queue is empty
    } else {
        return ReadyQueue[front++];  // Dequeue the front process
    }
}

void execute(int num_processes) {
    int current_time = 0;  // Keep track of the current CPU time
    
    while (front < back) {
        Process p = deque();
        if (p.pnum != 0) {
            printf("Process %d is sent to the CPU\n", p.pnum);
            
            // Calculate waiting time
            wt = current_time - p.at;
            if (wt < 0) wt = 0;  // If a process arrives late, waiting time is 0
            
            // Calculate turnaround time (waiting time + burst time)
            tt = wt + p.bt;
            
            // Add to total waiting time and total turnaround time
            total_wt += wt;
            total_tt += tt;
            
            // Update the current time to reflect the time after the process has finished executing
            current_time += p.bt;
            printf("Process %d has been executed successfully\n", p.pnum);
            printf("Waiting time: %d, Turnaround time: %d\n", wt, tt);
        }
    }
    
    // Calculate average waiting time and average turnaround time
    float avg_wt = (float)total_wt / num_processes;
    float avg_tt = (float)total_tt / num_processes;
    
    // Output average waiting time and average turnaround time
    printf("\nAverage Waiting Time: %f\n", avg_wt);
    printf("Average Turnaround Time: %f\n", avg_tt);
}
