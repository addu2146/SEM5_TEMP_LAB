public class Stack{
    private int SIZE;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        this.SIZE = size;
        this.stackArray = new int[SIZE];
        top = -1;
    }
     void push(int element){
        if(top==SIZE){
        System.out.println("STACK FULL");
        }
        else{
            stackArray[++top]=element;
        }
    }
     void pop(){
        if(top==-1){
            System.out.println("EMPTY");
        }
        else{
            top--;
        }
    }
     void peek(){
        if(top==-1){
            System.out.println("The stack is empty");
        }
        System.out.println("THE TOP ELEMENT IS :"+stackArray[top]);
     }
     public static void main(String[] args) {
        Stack stack = new Stack(20);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.pop();
        stack.peek();
     }
    }
