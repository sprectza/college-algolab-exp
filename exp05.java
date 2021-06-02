package VTULabExperiments;

/*
    @author Swarit Pandey
    IntelliJ IDEA Ultimate
    Lab Exp 05:
    Task:   Write a Java program to read two integers a and b. Compute a/b and print, when b is not zero.
            Raise an exception when b is equal to zero.
 */


import java.util.Scanner;

public class DAALabExp05 {
    public static void main(String[] args) {
        System.out.println("Enter A and B");
        Scanner scanData = new Scanner(System.in);
        int a = scanData.nextInt();
        int b = scanData.nextInt();

        try {
            int res = a / b;
            System.out.println(res);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
