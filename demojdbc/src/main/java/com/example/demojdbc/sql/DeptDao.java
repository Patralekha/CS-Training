package com.example.demojdbc.sql;

import com.example.demojdbc.model.Dept;
import com.example.demojdbc.model.Emp;
import com.example.demojdbc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DeptDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Collection<Dept> findAllDept() {
        List<Dept> deptList = new ArrayList<>();
        deptList=jdbcTemplate.query("select * from dept", new RowMapper<Dept>() {

            @Override
            public Dept mapRow(ResultSet resultSet, int i) throws SQLException {
                Dept dept=new Dept();
                dept.setDeptId(resultSet.getInt("dept_id"));
                dept.setDeptName(resultSet.getString("dept_name"));
                return dept;
            }
        });
        return deptList;
    }

    public Collection<Dept> findDeptById(Integer id) {
        List<Dept> deptList = new ArrayList<>();
        deptList=jdbcTemplate.query("select * from dept where dept_id ="+id, new RowMapper<Dept>() {

            @Override
            public Dept mapRow(ResultSet resultSet, int i) throws SQLException {
                Dept dept=new Dept();
                dept.setDeptId(resultSet.getInt("dept_id"));
                dept.setDeptName(resultSet.getString("dept_name"));

                return dept;
            }
        });
        return deptList;
    }

    public boolean addDept(Dept d){
        String insert=" insert into dept value(?,?)";
        int result=jdbcTemplate.update(insert, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,d.getDeptId());
                preparedStatement.setString(2,d.getDeptName());

            }
        });
        return result>0;
    }


    public boolean addDeptBetter(Dept d){
        String insert=" insert into dept value(:deptId,:deptName)";
        int result = namedParameterJdbcTemplate.update(insert, new BeanPropertySqlParameterSource(d));
        return result>0;
    }


}
