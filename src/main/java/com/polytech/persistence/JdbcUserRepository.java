package com.polytech.persistence;

import com.polytech.services.User;

import javax.sql.DataSource;

public class JdbcUserRepository {
    private DataSource dataSource ;

    public JdbcUserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(User user) {

    }
}
