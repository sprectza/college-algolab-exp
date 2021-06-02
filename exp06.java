package VTULabExperiments;

/*
    @author Swarit Pandey
    IntelliJ IDEA Ultimate
    Lab Exp 06:
    Task:   Write a Java program that implements a multi-thread application that has three threads. First
            thread generates a random integer for every 1 second; second thread computes the square of
            the number and prints; third thread will print the value of cube of the number.
 */

import java.util.Random;

class Thread2 implements Runnable { // Printing the square of an int
    int num;
    Thread2(int num) {
        this.num = num;
    }
    @Override
    public void run() {
        long ret = (long) num * num;
        System.out.println("Square of a number from Thread 2: " + ret);
    }
}

class Thread3 implements Runnable { // Printing the cube of a number
    int num;
    Thread3(int num) {
        this.num = num;
    }
    @Override
    public void run() {
        long ret = (long) num * num * num;
        System.out.println("Cube of a number from Thread 3: " + ret);
    }
}

class Thread1 implements Runnable { // Printing a random int
    @Override
    public void run() {
        for(int i = 0; i < 10; ++i) {
            Random rand = new Random();
            int num = rand.nextInt(100);
            System.out.println("A random number from Thread 1: " + num);

            Thread2 t2 = new Thread2(num);
            Thread thrTwo = new Thread(t2);
            thrTwo.start();

            Thread3 t3 = new Thread3(num);
            Thread thrThree = new Thread(t3);
            thrThree.start();

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Caught: " + e);
            }

            System.out.println();
        }
    }
}

public class DAALabExp06 {
    public static void main(String[] args) {
        // Random Integer Thread
        Thread1 t1 = new Thread1();
        Thread thrOne = new Thread(t1);
        thrOne.start();
    }
}
