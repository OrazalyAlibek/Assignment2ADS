package src;

public class Stack {
    private String[] data;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.data = new String[capacity];
        this.top = -1;
    }

    public void push(String value){
        if (top == capacity - 1) {
            System.out.println("Stack is full");
            return;
        }
        data[++top] = value;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public String pop(){
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        return data[top--];
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return data[top];
    }

    public int size(){
        return top + 1;
    }

}
