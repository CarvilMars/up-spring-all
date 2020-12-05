package com.up.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/employees")
    public Map<String, Object> list() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from employee");
        return maps.get(0);
    }
}
