#include <stdio.h>

typedef struct {
    int id;
    int burst_time;
    int priority;
    int waiting_time;
    int turnaround_time;
}Process;

void findWaitingTime( Process processes[], int n) {
    processes[0].waiting_time = 0; // First process has no waiting time

    for (int i = 1; i < n; i++) {
        processes[i].waiting_time = processes[i - 1].waiting_time + processes[i - 1].burst_time;
    }
}

void findTurnaroundTime( Process processes[], int n) {
    for (int i = 0; i < n; i++) {
        processes[i].turnaround_time = processes[i].burst_time + processes[i].waiting_time;
    }
}

void sortByPriority( Process processes[], int n) {
    // Simple bubble sort based on priority
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (processes[j].priority > processes[j + 1].priority) {
                Process temp = processes[j];
                processes[j] = processes[j + 1];
                processes[j + 1] = temp;
            }
        }
    }
}

void findAvgTime( Process processes[], int n) {
    findWaitingTime(processes, n);
    findTurnaroundTime(processes, n);

    float total_waiting_time = 0, total_turnaround_time = 0;
    printf("\nProcess\tBurst Time\tPriority\tWaiting Time\tTurnaround Time\n");
    for (int i = 0; i < n; i++) {
        total_waiting_time += processes[i].waiting_time;
        total_turnaround_time += processes[i].turnaround_time;
        printf("%d\t%d\t\t%d\t\t%d\t\t%d\n", processes[i].id, processes[i].burst_time, processes[i].priority, processes[i].waiting_time, processes[i].turnaround_time);
    }

    printf("\nAverage Waiting Time: %.2f\n", total_waiting_time / n);
    printf("Average Turnaround Time: %.2f\n", total_turnaround_time / n);
}

int main() {
    int n;
    printf("Enter the number of processes: ");
    scanf("%d", &n);

     Process Readyqueue[n];

    for (int i = 0; i < n; i++) {
        Readyqueue[i].id = i + 1; // Assigning process IDs
        printf("Enter burst time for Process %d: ", Readyqueue[i].id);
        scanf("%d", &Readyqueue[i].burst_time);
        printf("Enter priority for Process %d (lower number means higher priority): ", Readyqueue[i].id);
        scanf("%d", &Readyqueue[i].priority);
    }

    // Sort processes by priority
    sortByPriority(Readyqueue, n);

    findAvgTime(Readyqueue, n);

    return 0;
}
