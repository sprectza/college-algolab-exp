package VTULabExperiments;

/*
    @author Swarit Pandey
    Written on IntelliJ IDEA Ultimate
    Lab Exp 03:
    Task:   Design a superclass called Staff with details as StaffId, Name, Phone, Salary. Extend this
            class by writing three subclasses namely Teaching (domain, publications), Technical
            (skills), and Contract (period). Write a Java program to read and display at least 3 staff
            objects of all three categories.

    DISCLAIMER:         VERY CUMBERSOME CODE, STICK TO WHAT'S TAUGHT IN CLASS
 */

import java.util.ArrayList;
import java.util.Scanner;

class Staff {
    String staffId;
    String name;
    String phone;
    String salary;
    Staff (String staffId, String name, String phone, String salary) {
        this.staffId = staffId;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }
}

class Teaching extends Staff {
    String domain;
    String publications;
    Teaching(String staffId, String name, String phone, String salary, String domain, String publications) {
        super(staffId, name, phone, salary);
        this.domain = domain;
        this.publications = publications;
    }
}

class Technical extends Staff {
    String skills;
    Technical(String staffId, String name, String phone, String salary, String skills) {
        super(staffId, name, phone, salary);
        this.skills = skills;
    }
}

class Contract extends Staff {
    String period;
    Contract(String staffId, String name, String phone, String salary, String period) {
        super(staffId, name, phone, salary);
        this.period = period;
    }
}

public class DAALabExp03 {
    static ArrayList<Staff> keep = new ArrayList<>();
    static ArrayList<Teaching> keepTeachingData = new ArrayList<>();
    static ArrayList<Technical> keepTechnicalData = new ArrayList<>();
    static ArrayList<Contract> keepContractData = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanData = new Scanner(System.in);

        int n = 0;
        System.out.println("Enter the number of employees: ");
        n = scanData.nextInt();

        while(n != 0) {
            System.out.println("General details of employee: ");
            System.out.println("Enter the StaffID of the employee: ");
            String staffId = scanData.next();
            scanData.nextLine();

            System.out.println("Enter the Name of the employee: // Current StaffID: " + staffId);
            String name = scanData.next();
            scanData.nextLine();

            System.out.println("Enter the Phone No. of the employee: // Current StaffID: " + staffId);
            String phone = scanData.next();
            scanData.nextLine();

            System.out.println("Enter the salary of the employee: // Current StaffID: " + staffId);
            String salary = scanData.next();
            scanData.nextLine();

            keep.add(new Staff(staffId, name, phone, salary));

            System.out.println("--------------------------------------------------------------------------");

            System.out.println("Enter the TEACHING Details of employee: // Current StaffID: " + staffId);
            System.out.println("Enter the Domain of the employee: // Current StaffID: " + staffId);
            String domain = scanData.next();
            scanData.nextLine();

            System.out.println("Enter the publication details of the employee: // Current StaffID: " + staffId);
            String publications = scanData.next();
            scanData.nextLine();

            keepTeachingData.add(new Teaching(staffId, name, phone, salary, domain, publications));

            System.out.println("---------------------------------------------------------------------------");

            System.out.println("Enter the TECHNICAL Details of employee: // Current StaffID: " + staffId);
            System.out.println("Enter the technical skill of employee: // Current StaffID: " + staffId);
            String skills = scanData.next();
            scanData.nextLine();

            keepTechnicalData.add(new Technical(staffId, name, phone, salary, skills));

            System.out.println("----------------------------------------------------------------------------");

            System.out.println("Enter the CONTRACT Data of employee: // Current StaffID: " + staffId);
            String period = scanData.next();
            scanData.nextLine();

            keepContractData.add(new Contract(staffId, name, phone, salary, period));

            System.out.println("Details for employee with StaffID: " + staffId + " are filled.");
            System.out.println("//////////////////////////////////////////////////////////////////////////////");
            n--;
        }

        System.out.println("Query over employee details: (Y/N)");
        String initialQueryResponse = scanData.nextLine();
        if(initialQueryResponse.equals("Y")) {
            initiateQueryResponse();
        } else if(initialQueryResponse.equals("N")) {
            System.exit(0);
        } 
    }

    private static void initiateQueryResponse() {
        Scanner scanData = new Scanner(System.in);
        System.out.println("You can search by StaffID (a)\nSee detail of all employees (b)\nPress (X) to exit.");

        while (true) {
            String fromKeyboard = scanData.next();
            switch (fromKeyboard) {
                case "a" -> {
                    System.out.println("Enter the StaffID: ");
                    String idResponse = scanData.next();
                    boolean check = checkIfIDExists(idResponse);
                    if(check) queryByID(idResponse);
                    else System.out.println("ID does not exists!");
                }
                case "b" -> {
                    printEverything();
                }
                case "X" -> System.exit(0);
                default -> System.out.println("Press (a), (b) or (X)");
            }
        }
    }

    private static boolean checkIfIDExists(String idResponse) {
        for(Staff obj : keep) {
            if(idResponse.equals(obj.staffId)) {
                return true;
            }
        }
        return false;
    }

    private static void printEverything() {
        for(Staff obj : keep) {
            System.out.println("Name: " + obj.name);
            System.out.println("Salary: " + obj.salary);
            System.out.println("Phone: " + obj.phone);
            System.out.println("Staff ID: " + obj.staffId);
        }
    }

    private static void queryByID(String queryForID) {
        for(Staff obj : keep) {
            if(queryForID.equals(obj.staffId)) {
                System.out.println("The details are: ");
                System.out.println("Name: " + obj.name);
                System.out.println("Salary: " + obj.salary);
                System.out.println("Phone: " + obj.phone);
                printTeachingDetails(queryForID);
                printTechnicalDetails(queryForID);
                printContractDetails(queryForID);
            }
        }
    }

    private static void printContractDetails(String queryForID) {
        for(Contract obj : keepContractData) {
            if(queryForID.equals(obj.staffId)) {
                System.out.println("Contract period is: " + obj.period);
                return;
            }
        }
    }

    private static void printTechnicalDetails(String queryForID) {
        System.out.println("TECHNICAL DETAILS: ");
        for(Technical obj : keepTechnicalData) {
            if(queryForID.equals(obj.staffId)) {
                System.out.println("Skill is: " + obj.skills);
            }
        }
    }

    private static void printTeachingDetails(String queryForID) {
        System.out.println("TEACHING DETAILS: ");
        for(Teaching obj : keepTeachingData) {
            if(queryForID.equals(obj.staffId)) {
                System.out.println("Domain is: " + obj.domain);
                System.out.println("Publications: " + obj.publications);
            }
        }
    }
}
