package domain.service;

import domain.model.Employee;
import domain.model.EmployeeType;

import java.util.ArrayList;

public class EmployeeServiceInMemory implements EmployeeService {

    private int id = 0;
    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeServiceInMemory() {
        this.addEmployee(new Employee(id, "Jan-Willem", "jw@wg.be", "pwd", EmployeeType.valueOf("KCC")));
        this.addEmployee(new Employee(id, "Yannick", "yv@wg.be", "psw", EmployeeType.valueOf("TECHNICIAN")));
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        id++;
    }

    @Override
    public Employee findEmployeeWithEmail(String email) {
        for(Employee u : employees){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }
}
