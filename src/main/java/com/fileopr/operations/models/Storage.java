package com.fileopr.operations.models;

import java.io.*;
import java.util.*;

public class Storage {

    HashMap<Integer, Employee> map;

    public boolean addEmployee(Employee emp) {
        if(emp!=null && this.checkData(emp)!=false)
        {
            map=readfile();
            map.put(emp.getId(),emp);
            writefile(map);
            return true;
        }
        return false;
    }

    private boolean checkData(Employee emp) {
        return emp.verify();
    }

    public Employee getEmployee(int id) {
        map=readfile();
        Employee emp = map.get(id);
        return emp;
    }

    public boolean updateEmployee(Employee emp) {
        map=readfile();
        Employee emp1 = map.get(emp.getId());
        emp1.setName(emp.getName());
        emp1.setCompany(emp.getCompany());
        emp1.setDob(emp.getDob());
        emp1.setSalary(emp.getSalary());
        writefile(map);
        return true;
    }

    public boolean deleteEmployee(int id) {
        map=readfile();
        map.remove(id);
        writefile(map);
        return true;
    }

    public List<Employee> listAll() {
        map=readfile();
        List<Employee>emp = new ArrayList<>();
        Set<Integer> id = map.keySet();
        for(Integer i:id)
        {
            emp.add(map.get(i));
        }
        return emp;
    }

    private HashMap<Integer,Employee> readfile(){
        try{
            File toRead=new File("output");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            map= (HashMap<Integer,Employee>)ois.readObject();
            ois.close();
            fis.close();
        }catch(Exception e){}
        return map;
    }

    private void writefile(HashMap<Integer,Employee> map){
        try{
            File fileOne=new File("output");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.flush();
            oos.close();
            fos.close();
        }catch(Exception e){}
    }
}
