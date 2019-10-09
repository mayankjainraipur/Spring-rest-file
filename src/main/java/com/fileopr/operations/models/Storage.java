package com.fileopr.operations.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Storage {

    HashMap<Integer, Employee> map = new HashMap<>();

    public boolean addEmployee(Employee emp) {
        if(emp!=null && this.checkData(emp)!=false)
        {
            map.put(emp.getId(),emp);
            return true;
        }
        return false;
    }

    private boolean checkData(Employee emp) {
        return emp.verify();
    }

    public Employee getEmployee(int id) {

        Employee emp = map.get(id);
        return emp;
    }

    public boolean updateEmployee(Employee emp) {
        Employee emp1 = map.get(emp.getId());
        emp1.setName(emp.getName());
        emp1.setCompany(emp.getCompany());
        emp1.setDob(emp.getDob());
        emp1.setSalary(emp.getSalary());
        return true;
    }

    public boolean deleteEmployee(int id) {
        map.remove(id);
        return true;
    }

    public List<Employee> listAll() {
        List<Employee>emp = new ArrayList<>();
        Set<Integer> id = map.keySet();
        for(Integer i:id)
        {
            emp.add(map.get(i));
        }
        return emp;
    }
}
