package com.example.demojdbc.sql;

import com.example.demojdbc.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class EmpDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Collection<Emp> findAll() {
        List<Emp> empList = new ArrayList<>();
        empList=jdbcTemplate.query("select * from emp", new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp=new Emp();
                emp.setEmpId(resultSet.getInt("emp_id"));
                emp.setEmpName(resultSet.getString("emp_name"));
                emp.setSalary(resultSet.getString("salary"));
                return emp;
            }
        });
        return empList;
    }

    public Collection<Emp> findById(Integer id) {
        List<Emp> empList = new ArrayList<>();
        empList=jdbcTemplate.query("select * from emp where emp_id ="+id, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp=new Emp();
                emp.setEmpId(resultSet.getInt("emp_id"));
                emp.setEmpName(resultSet.getString("emp_name"));
                emp.setSalary(resultSet.getString("salary"));
                return emp;
            }
        });
        return empList;
    }

    public boolean addEmp(Emp e){
        String insert=" insert into emp value(?,?,?)";
        int result=jdbcTemplate.update(insert, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,e.getEmpId());
                preparedStatement.setString(2,e.getEmpName());
                preparedStatement.setString(3,e.getSalary());
            }
        });
        return result>0;
    }


}
