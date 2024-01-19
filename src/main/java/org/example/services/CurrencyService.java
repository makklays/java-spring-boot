package org.example.services;

import org.example.domain.Currency;
import org.example.repository.CurrencyRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final SessionFactory sessionFactory;
    private final CurrencyRepository currencyRepository;

    public CurrencyService(SessionFactory sessionFactory, CurrencyRepository currencyRepository) {
        this.sessionFactory = sessionFactory;
        this.currencyRepository = currencyRepository;
    }

    // get records of currency by period
    public List<Currency> getCurrencyByPeriod(String date_from, String date_to) {
        if (date_from.isEmpty()) date_from = "2024-01-01";
        if (date_to.isEmpty()) date_to = "2024-12-31";

        try {
            System.out.println("Hibernate get records of currency by period");
            Session session = sessionFactory.openSession();//HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM CurrencyEntity WHERE exchangedate BETWEEN '" + date_from + "' AND '" + date_to + "'  ORDER BY exchangedate DESC");
            List<Currency> currencyList = query.list(); // or query.getResultList();

            session.getTransaction().commit();
            session.close();

            return currencyList;

        } catch (Exception e) {
            System.out.println("Exception! Error message: " + e.getMessage());
        }

        return null;
    }

    // get records (logs) from database (table currencies)

}

