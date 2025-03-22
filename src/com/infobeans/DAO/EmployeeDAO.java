package com.infobeans.DAO;

import com.infobeans.model.Employee;
import org.w3c.dom.css.CSSStyleDeclaration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;

public class EmployeeDAO {
    String url = "jdbc:mysql://localhost:3306/Layered";
    String user = "root";
    String password = "Ritika@123";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    // method to insert an Employee
    public void insertEmployee(Employee e1) throws SQLException {
        String sql = "insert into Employee(id,name,department,salary) values (?,?,?,?)";
        Connection con = getConnection();
        PreparedStatement rt = con.prepareStatement(sql);
        rt.setInt(1,e1.getId());
        rt.setString(2,e1.getName());
        rt.setString(3, e1.getDepartment());
        rt.setInt(4,e1.getSalary());
        rt.executeUpdate();
        System.out.println("Employee Added Successfully");
    }
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from Employee";
        Connection con= getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Employee employee = new Employee(
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getString("Department"),
                    rs.getInt("Salary")

            );
            employees.add(employee);
        }
        return employees;
    }
}
