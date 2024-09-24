#include<stdio.h>
//#include<brain.addu2146>
//Shortest Job First(SJF/SRTF)
typedef struct {
    int pnum;  // Process ID
    int at;   //
    int bt;    // Burst time
} Process;

int wt = 0;  
int tt = 0;  
int total_wt = 0; 
int total_tt = 0; 

#define SIZE 20
Process ReadyQueue[SIZE];
int front = 0;
int back = 0;

void enque(Process p);
Process deque();
Process SelectforEnque(Process p[], int num_Processes);
void execute(int num_processes);
int main(){
    int num_processes;
    printf("Enter The Number of Processes You Want to Get executed\n");
    scanf("%d", &num_processes);

    // Initialize an array to store processes
    Process Batch[num_processes];
    
    // Get process details
    int i;
    for ( i = 0; i < num_processes; i++) {
        printf("Enter the burst time of Process %d:\n", i + 1);
        scanf("%d", &Batch[i].bt);
        Batch[i].at=0;
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

Process SelectforEnque(Process p[], int num_Processes) {//Non preemptive
    Process First_Process = p[0];
    int i;
    
    for ( i = 1; i < num_Processes; i++) {
        if (p[i].bt < First_Process.bt) {
            First_Process = p[i];  // Select the process with the least burst time
        }
    }
    
    return First_Process;
}
void enque(Process p) {
    if (back == SIZE) {
        printf("ReadyQueue is full, wait for a process to complete\n");
    } else {
        ReadyQueue[back++] = p;  // Insert process in the queue
//printf("Process %d was fetched to the Ready queue\n", p.pnum);
    }
}
Process deque() {
    if (front == back) {
        printf("ALL PROCESSES COMPLETE\n");
        Process empty = {0, 0};
        return empty;  // Return an empty process if the queue is empty
    } else {
        // ReadyQueue[front+1].at= ReadyQueue[front].bt;
        return ReadyQueue[front++];  // Dequeue the front process
        
    }
}
void execute(int num_processes) {
    int current_time = 0;  // Keep track of the current CPU time
    
    while (front < back) {
        Process p = deque();
        
        printf("Process %d with Arrival time : %d and burst time : %d sent to the CPU at %d time\n",p.pnum,p.at,p.bt,current_time);
             wt = current_time - p.at;
             current_time += p.bt;
            // Calculate waiting time
            
            
            if (wt < 0) wt = 0;  // If a process arrives late, waiting time is 0
            
            // Calculate turnaround time (waiting time + burst time)
            tt = wt + p.bt;
            
            // Add to total waiting time and total turnaround time
            total_wt += wt;
            total_tt += tt;
            
            // Update the current time to reflect the time after the process has finished executing
            
           // printf("Process %d has been executed successfully\n", p.pnum);
            printf("Waiting time: %d, Turnaround time: %d\n", wt, tt);
        }
        // Calculate average waiting time and average turnaround time
    float avg_wt = (float)total_wt / num_processes;
    float avg_tt = (float)total_tt / num_processes;
    
    // print average waiting time and average turnaround time
    printf("\nAverage Waiting Time: %f\n", avg_wt);
    printf("Average Turnaround Time: %f\n", avg_tt);
    }
