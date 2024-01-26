package org.example.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@TestConfiguration
public class DataSourceConfiguration {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:h2:mem:test" );
        config.setDriverClassName( "org.h2.Driver");
        config.setUsername( "admin" ); // "root"
        config.setPassword( "admin" ); // "root"
        ds = new HikariDataSource( config );
    }

    public DataSourceConfiguration() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    @Bean
    public HikariDataSource dataSource() {
        return new HikariDataSource(config);
    }
}
