package org.example.repository;

import org.example.domain.Currency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * Class: CurrencyRepository
 * Description: General methods for Currencies (CRUD and several search)
 */
@Repository
public class CurrencyRepository {

    private static final Logger log = LoggerFactory.getLogger(CurrencyRepository.class);
    private static final String EXCEPTION = "Exception! Error message: {}";
    private final SessionFactory sessionFactory;

    public CurrencyRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    // insert - yo te quiero MyGirl :-)
    public boolean insertCurrency(Currency currency) {

        try {
            Session session = sessionFactory.openSession();
            log.info("Hibernate insert records of currency {}", currency);
            session.beginTransaction();
            session.persist(currency);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            log.error(EXCEPTION, e.getMessage());
        }
        return false;
    }

    // get data by currency code
    public List<Currency> getCurrency(String currencyCode) {
        try {
            Session session = sessionFactory.openSession();
           log.info("Hibernate get records of currency by currency_code{}", currencyCode);

            List<Currency> currencyList = session
                    .createQuery("FROM Currency WHERE cc = '" + currencyCode + "' ", Currency.class)
                    .getResultList();
            sessionFactory.close();

            return currencyList;

        } catch (Exception e) {
            log.error(EXCEPTION, e.getMessage());
        }
        return Collections.emptyList();
    }

    // get data by currency by period (dates)
    public List<Currency> getCurrencyByPeriod(String date_from, String date_to) {
        if (date_from.isEmpty()) date_from = "2024-01-01";
        if (date_to.isEmpty()) date_to = "2024-12-31";

        try {
            Session session = sessionFactory.openSession();
            log.info("Hibernate get records of currency by date_from{} and date_to{}", date_from, date_to);

            List<Currency> currencyList = session
                    .createQuery("FROM Currency  WHERE created_at BETWEEN '" + date_from + "' AND '" + date_to + "'  ORDER BY created_at DESC", Currency.class)
                    .getResultList();
            sessionFactory.close();

            return currencyList;

        } catch (Exception e) {
            log.error(EXCEPTION, e.getMessage());
        }
        return Collections.emptyList();
    }

    // update
    public boolean updateCurrency(Currency currency) {
        try {
            Session session = sessionFactory.openSession();
            log.info("Hibernate update record of currency by currency{}", currency);

            session.beginTransaction();
            session.persist(currency);
            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            log.error(EXCEPTION, e.getMessage());
        }
        return false;
    }

    // delete
    public boolean deleteCurrency(Currency currency) {
        try {
            Session session = sessionFactory.openSession();
            log.info("Hibernate delete record of currency by currency{}", currency);

            session.beginTransaction();
            session.persist(currency);
            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            log.error(EXCEPTION, e.getMessage());
        }
        return false;
    }
}

