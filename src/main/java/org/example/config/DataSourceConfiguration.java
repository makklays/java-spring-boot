package org.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DataSourceConfiguration {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:mysql://localhost:3306/currency_rest" );
        config.setDriverClassName( "com.mysql.jdbc.Driver");
        config.setUsername( "admin" ); // "root"
        config.setPassword( "admin" ); // "root"
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
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
