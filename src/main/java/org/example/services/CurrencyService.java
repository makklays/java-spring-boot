package org.example.services;

import org.example.config.HibernateSessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    // get records of currency by period
    public List<Object> getCurrencyByPeriod(String date_from, String date_to) {
        if (date_from.isEmpty()) date_from = "2024-01-08";
        if (date_to.isEmpty()) date_to = "2024-01-08";

        try {
            System.out.println("Hibernate get records of currency by period");
            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM `currency` WHERE exchangedate > " + date_from + " AND exchangedate < " + date_to + " ORDER BY exchangedate DESC");
            List<Object> currencyList = query.list(); // or query.getResultList();

            session.getTransaction().commit();
            session.close();

            return currencyList;

        } catch (Exception e) {
            System.out.println("Exception! Error message: " + e.getMessage());
        }

        return null;
    }
}

