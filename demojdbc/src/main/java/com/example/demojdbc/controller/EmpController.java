package com.example.demojdbc.controller;

import com.example.demojdbc.model.Emp;
import com.example.demojdbc.service.EmpService;
import com.example.demojdbc.sql.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class EmpController {

   // @Autowired
    //EmpDao empService;
    @Autowired
    EmpService empService;

    @GetMapping("/findall")
    public Collection<Emp> getAllEmp(){
        return empService.getAll();
    }

    @GetMapping("/findbyid")
    public Collection<Emp> findById(@RequestParam Integer id){
         return empService.findById(id);
    }

    @PostMapping("/addemp")
    public boolean addEmp(@RequestBody Emp emp){
        return empService.add(emp);
    }


}
