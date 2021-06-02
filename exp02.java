package VTULabExperiments;

/*
    @author Swarit Pandey
    Lab Experiment 02:
    Implement Stack using arrays with following methods:
        a) push()
        b) pop()
        c) display()
 */

import java.util.Scanner;

class Stack {
    int[] arr;
    int top;
    int size;

    Stack (int size, int[] arr) {
        this.size = size;
        this.arr = arr;
        top = -1;
    }

    void push(int ele) {
        if(isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = ele;
    }

    int pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflow");
        }
        top--;
        return arr[top];
    }

    boolean isFull() {
        return top == size - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void display() {
        int i = top;
        while(i >= 0) {
            System.out.print(arr[i] + " | ");
            i--;
        }
    }
}

class DAALabExp02 {
    public static void main(String[] args) {
        Scanner scanData = new Scanner(System.in);
        System.out.println("Enter the size of the stack: ");
        int size = scanData.nextInt();

        int[] arr = new int[size];

        Stack stk = new Stack(size, arr);

        while(true) {
            System.out.println("a) Push b) Pop c) Display d) Exit");
            String response = scanData.next();
            switch (response) {
                case "a" -> {
                    System.out.println("Enter the element you want to push: ");
                    int ele = scanData.nextInt();
                    stk.push(ele);
                }
                case "b" -> {
                    int ret = stk.pop();
                    System.out.println("Element popped is: " + ret);
                }
                case "c" -> stk.display();
                case "d" -> System.exit(0);

                default -> System.out.println("Enter a correct choice.");
            }
        }
    }
}
