package org.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.example.domain.Channel;
import org.example.domain.Company;
import org.example.domain.Currency;
import org.example.domain.User;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import java.util.Properties;
import java.util.TimeZone;

@org.springframework.context.annotation.Configuration
public class HibernateSessionFactoryConfiguration {

    @Autowired
    private HikariDataSource hikariDataSource;

    @Autowired
    Environment env;

    private synchronized  SessionFactory buildSessionFactory() {

        // variant 1
        /*Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // in src/main/resources/hibernate.cfg.xml
        //creating seession factory object
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
                .build();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);*/

        // variant 2
        Configuration configuration = new Configuration();
        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        Properties settings = new Properties();
        settings.put(AvailableSettings.CONNECTION_PROVIDER, "com.zaxxer.hikari.hibernate.HikariConnectionProvider");
        settings.put(AvailableSettings.DATASOURCE, hikariDataSource);
        settings.put(AvailableSettings.SHOW_SQL, "true");

        if(env.acceptsProfiles(Profiles.of("test"))){
            settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.H2Dialect");
        } else {
            settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        }
        //settings.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        //settings.put(AvailableSettings.GLOBALLY_QUOTED_IDENTIFIERS, "true");
        settings.put(AvailableSettings.HBM2DDL_AUTO, "update");

        settings.put(
            AvailableSettings.JDBC_TIME_ZONE,
            TimeZone.getTimeZone("UTC")
        );

        configuration.setProperties(settings);

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Channel.class);
        configuration.addAnnotatedClass(Currency.class);
        //configuration.addAnnotatedClass(CreditCardEntity.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }



    @Bean
    public SessionFactory getSession() {
        return buildSessionFactory();
    }

}

