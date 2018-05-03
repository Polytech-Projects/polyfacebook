package com.polytech.config;

import com.polytech.persistence.InMemoryStoryRepository;
import com.polytech.persistence.JdbcStoryRepository;
import com.polytech.persistence.StoryRepository;
import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.UserService;
import com.polytech.web.FeedController;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public StoryRepository storyRepository(JdbcTemplate jdbcTemplate) throws SQLException {
        return new JdbcStoryRepository(jdbcTemplate);
    }

    @Bean
    public FeedService
    feedService(StoryRepository storyRepository) {
        return new FeedService(storyRepository);
    }

    @Bean
    public PublicationService publicationService(StoryRepository storyRepository) {
        return new PublicationService(storyRepository);
    }

    @Bean
    public FeedController feedController(PublicationService publicationService, FeedService feedService) {
        return new FeedController(publicationService, feedService);
    }

    @Bean
    public DataSource dataSource() {
        //return new EmbeddedDatabaseBuilder()
                //.addScripts("schema.sql")
          //      .build();
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:mysql://localhost/data_base_name");
        hikariDataSource.setUsername("user");
        hikariDataSource.setPassword("password");
        return hikariDataSource;
    }
}
