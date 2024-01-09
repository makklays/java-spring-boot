package org.example.repository;

import org.example.config.HibernateSessionFactoryConfiguration;
import org.example.domain.CurrencyEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class: CurrencyRepository
 * Description: General methods for Currencies (CRUD and several search)
 */
public class CurrencyRepository {
    // insert - yo te quiero MyGirl :-)
    public boolean insertCurrency(CurrencyEntity currency) {
        try {
            System.out.println("Hibernate insert records of currency");
            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(currency);

            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            System.out.println("Exception! Error message: " + e.getMessage());
        }

        return false;
    }

    // get data by currency code
    public List<Object> getCurrency(String currency_code) {
        try {
            System.out.println("Hibernate get records of currency by currency_code");
            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM `currency` WHERE cc = '" + currency_code + " ");
            List<Object> currencyList = query.list(); // or query.getResultList();

            session.getTransaction().commit();
            session.close();

            return currencyList;

        } catch (Exception e) {
            System.out.println("Exception! Error message: " + e.getMessage());
        }

        return null;
    }

    // get data by currency by period (dates)
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

    // update
    public boolean updateCurrency(CurrencyEntity currency) {
        try {
            System.out.println("Hibernate update record of currency");
            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(currency);

            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            System.out.println("Exception! Error message: " + e.getMessage());
        }

        return false;
    }

    // delete
    public boolean deleteCurrency(CurrencyEntity currency) {
        try {
            System.out.println("Hibernate delete record of currency");
            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
            session.beginTransaction();

            session.delete(currency);

            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            System.out.println("Exception! Error message: " + e.getMessage());
        }

        return false;
    }
}

