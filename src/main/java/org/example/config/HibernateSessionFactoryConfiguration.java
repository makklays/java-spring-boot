package org.example.config;

import org.example.domain.Channel;
import org.example.domain.Company;
import org.example.domain.CurrencyEntity;
import org.example.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;

import java.util.Properties;
import java.util.TimeZone;

public class HibernateSessionFactoryConfiguration {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    protected static SessionFactory buildSessionFactory() {

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
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver"); // com.mysql.jdbc.Driver
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/javafx_aibot");
        settings.put(Environment.USER, "admin");
        settings.put(Environment.PASS, "admin");

        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.GLOBALLY_QUOTED_IDENTIFIERS, "true");

        //settings.put(Environment.HBM2DDL_AUTO, "create-drop");

        settings.put(
            AvailableSettings.JDBC_TIME_ZONE,
            TimeZone.getTimeZone("UTC")
        );

        configuration.setProperties(settings);

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Channel.class);
        configuration.addAnnotatedClass(CurrencyEntity.class);
        //configuration.addAnnotatedClass(CreditCardEntity.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}

