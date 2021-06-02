package VTULabExperiments;

/*
    @author Swarit Pandey
    IntelliJ IDEA Ultimate
    Lab Experiment 01:
    Write a Student class with following variables:
        a) USN
        b) Name
        c) Programme
        d) Phone
 */

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String Name;
    String USN;
    String Programme;
    String Phone;
    Student (String Name, String USN, String Programme, String Phone) {
        this.Name = Name;
        this.USN = USN;
        this.Programme = Programme;
        this.Phone = Phone;
    }
}

public class DAALabExp01 {
    public static void main(String[] args) {
        ArrayList<Student> keep = new ArrayList<>();
        int n;
        Scanner scanData = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        n = scanData.nextInt();

        System.out.println("Enter the details: ");
        while(n != 0) {
            System.out.println("Enter the Name: ");
            String name = scanData.next();
            scanData.nextLine();

            System.out.println("Enter the USN: ");
            String usn = scanData.next();
            scanData.nextLine();

            System.out.println("Enter the Programme: ");
            String programme = scanData.next();
            scanData.nextLine();

            System.out.println("Enter the Phone No: ");
            String phone = scanData.next();
            scanData.nextLine();

            keep.add(new Student(name, usn, programme, phone));
            n--;
        }

        for (Student ob : keep) {
            System.out.println("Name of the Student is: " + ob.Name);
            System.out.println("USN of the Student is: " + ob.USN);
            System.out.println("Student is enrolled in: " + ob.Programme);
            System.out.println("Phone No. of student is: " + ob.Phone);
            System.out.println("\n");
        }
    }
}
