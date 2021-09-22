package com.example.demojdbc.service;

import com.example.demojdbc.model.Emp;
import com.example.demojdbc.sql.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmpService {

    @Autowired
    EmpDao empDao;

    public Collection<Emp> getAll(){
        return empDao.findAll();
    }

    public Collection<Emp> findById(Integer id){
        return empDao.findById(id);
    }

    public boolean add(Emp emp){
        return empDao.addEmp(emp);
    }
}
