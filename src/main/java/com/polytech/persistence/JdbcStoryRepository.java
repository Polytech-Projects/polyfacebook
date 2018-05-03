package com.polytech.persistence;

import com.polytech.services.Story;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcStoryRepository implements StoryRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcStoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Story story) {
        jdbcTemplate.update("INSERT INTO STORY (CONTENT)VALUES(?)", story.getContent());
    }

    public List<Story> findAll() {
        return jdbcTemplate.query("SELECT * FROM STORY", new RowMapper<Story>() {
            @Override
            public Story mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Story(resultSet.getString("CONTENT"));
            }
        });
    }
}
