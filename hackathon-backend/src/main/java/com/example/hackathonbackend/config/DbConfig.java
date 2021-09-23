package com.example.hackathonbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Autowired
    DataSource dataSource;

    public NamedParameterJdbcTemplate getInstance(){
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
