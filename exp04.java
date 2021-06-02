package VTULabExperiments;

/*
    @author Swarit Pandey
    Written on IntelliJ IDEA Ultimate
    Lab Exp 04:
    Task:   Write a Java class called Customer to store their name and date_of_birth. The date_of_birth
            format should be dd/mm/yyyy. Write methods to read customer data as <name,
            dd/mm/yyyy> and display as <name, dd, mm, yyyy> using StringTokenizer class
            considering the delimiter character as “/”.
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Customer {
    String name;
    String date;
    Customer(String name, String date) {
        this.name = name;
        this.date = date;
    }
}

public class DAALabExp04 {
    public static void main(String[] args) {
        Scanner scanData = new Scanner(System.in);
        ArrayList<Customer> keep = new ArrayList<>();
        System.out.println("Enter the number of Customers: ");
        int n = scanData.nextInt();

        while(n != 0) {
            System.out.println("Enter the Name of the Customer: ");
            String name = scanData.next();

            System.out.println("Enter the date of birth in 'dd/mm/yyyy' format: ");
            String dob = scanData.next();

            keep.add(new Customer(name, dob));
            n--;
        }

        for(Customer obj : keep) {
            System.out.print(obj.name + ", ");
            String delimit = "/";
            StringTokenizer str = new StringTokenizer(obj.date, delimit);
            while(str.hasMoreElements()) {
                System.out.print(str.nextElement() + ", ");
            }
            System.out.println();
        }
    }
}
