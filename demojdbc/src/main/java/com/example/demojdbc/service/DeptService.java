package com.example.demojdbc.service;

import com.example.demojdbc.model.Dept;
import com.example.demojdbc.model.Emp;
import com.example.demojdbc.sql.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DeptService {

    @Autowired
    DeptDao deptDao;


    public Collection<Dept> getAll(){
        return deptDao.findAllDept();
    }

    public Collection<Dept> findById(Integer id){
        return deptDao.findDeptById(id);
    }

    public boolean add(Dept dept){
        return deptDao.addDept(dept);
    }

}
