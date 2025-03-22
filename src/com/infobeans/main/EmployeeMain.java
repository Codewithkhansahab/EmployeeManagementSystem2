package com.infobeans.main;

import com.infobeans.Service.EmployeeService;
import com.infobeans.model.Employee;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) throws SQLException{
        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();
        while(true){
            System.out.println("::: ---- ::: Employee Management System ::: --- ::: ");
            System.out.println("---- : Enter Your Choice What do you want to do : ----");
            System.out.println("=========================================================");
            System.out.println("Press 1 for Add New Employee ");
            System.out.println("Press 2 for View Employee ");
            System.out.println("Enter your Choice : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1 :
                    System.out.print("Enter Employee Id : ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Employee Name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Department : ");
                    String department = sc.nextLine();
                    System.out.print("Enter Salary : ");
                    int salary = Integer.parseInt(sc.nextLine());
                    Employee employee = new Employee(id,name,department,salary);
                    EmployeeService.addEmployee(employee);
                    break;
                case 2:
                    List<Employee> employees = EmployeeService.findAll();
                    System.out.println("\nEmployees List:");
                    for (Employee s : employees) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " + s.getDepartment() + " | " + s.getSalary());
                    }
                    break;
                case 3:
                    System.out.println("Exiting >>>>>>");
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice ");

            }
        }
    }

}
