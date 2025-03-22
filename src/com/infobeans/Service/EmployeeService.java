package com.infobeans.Service;

import com.infobeans.DAO.EmployeeDAO;
import com.infobeans.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private static EmployeeDAO employeeDAO;

    public EmployeeService(){
        employeeDAO = new EmployeeDAO();
    }
    public static void addEmployee(Employee e1) throws SQLException {
        employeeDAO.insertEmployee(e1);
    }
    public static List<Employee> findAll() throws SQLException {
        return employeeDAO.getAllEmployees();
    }
}
