#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 100 

// Define the stack structure
typedef struct {
    int array[MAX_SIZE]; 
    int top;             
} Stack;

// Function to initialize the stack
void initializeStack(Stack *stack) {
    stack->top = -1; // Stack is empty initially
}

// Function to check if the stack is empty
bool isEmpty(Stack *stack) {
    return stack->top == -1;
}

// Function to check if the stack is full
bool isFull(Stack *stack) {
    return stack->top == MAX_SIZE - 1;
}

// Function to push an element onto the stack
void push(Stack *stack, int item) {
    if (isFull(stack)) {
        printf("Stack overflow\n");
        return;
    }
    stack->array[++stack->top] = item;
}

// Function to pop an element from the stack
int pop(Stack *stack) {
    if (isEmpty(stack)) {
        printf("Stack underflow\n");
        exit(EXIT_FAILURE); // Exit if trying to pop from an empty stack
    }
    return stack->array[stack->top--];
}

// Function to peek at the top element of the stack
int peek(Stack *stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty\n");
        exit(EXIT_FAILURE); // Exit if trying to peek into an empty stack
    }
    return stack->array[stack->top];
}

// Function to get the size of the stack
int size(Stack *stack) {
    return stack->top + 1;
}

int main() {
    Stack stack;
    initializeStack(&stack);

    // Push elements
    push(&stack, 1);
    push(&stack, 2);
    push(&stack, 3);
    printf("Top element is %d\n", peek(&stack));

   //pop
    printf("Popped element is %d\n", pop(&stack)); 
    printf("Popped element is %d\n", pop(&stack)); 


    printf("Stack size is %d\n", size(&stack)); 
    printf("Stack is empty: %s\n", isEmpty(&stack) ? "Yes" : "No");  

   
    printf("Popped element is %d\n", pop(&stack)); 

    
    printf("Stack is empty: %s\n", isEmpty(&stack) ? "Yes" : "No"); 
    // printf("Popped element is %d\n", pop(&stack));

    return 0;
}
