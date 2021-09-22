package com.example.demojdbc.controller;

import com.example.demojdbc.model.Dept;
import com.example.demojdbc.model.Emp;
import com.example.demojdbc.service.DeptService;
import com.example.demojdbc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class DeptController {


    @Autowired
    DeptService deptService;

    @GetMapping("/findalldept")
    public Collection<Dept> getAllDept(){
        return deptService.getAll();
    }

    @GetMapping("/finddeptbyid")
    public Collection<Dept> findById(@RequestParam Integer id){
        return deptService.findById(id);
    }

    @PostMapping("/adddept")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.add(dept);
    }
}
