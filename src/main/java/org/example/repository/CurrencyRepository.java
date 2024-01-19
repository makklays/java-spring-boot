package org.example.repository;

import org.example.domain.CurrencyEntity;
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
    public boolean insertCurrency(CurrencyEntity currency) {

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
    public List<CurrencyEntity> getCurrency(String currencyCode) {
        try {
            Session session = sessionFactory.openSession();
           log.info("Hibernate get records of currency by currency_code{}", currencyCode);

            List<CurrencyEntity> currencyList = session
                    .createQuery("FROM CurrencyEntity WHERE cc = '" + currencyCode + "' ", CurrencyEntity.class)
                    .getResultList();
            sessionFactory.close();

            return currencyList;

        } catch (Exception e) {
            log.error(EXCEPTION, e.getMessage());
        }
        return Collections.emptyList();
    }
//
//    // get data by currency by period (dates)
//    public List<CurrencyEntity> getCurrencyByPeriod(String date_from, String date_to) {
//        if (date_from.isEmpty()) date_from = "2024-01-01";
//        if (date_to.isEmpty()) date_to = "2024-12-31";
//
//        try {
//            System.out.println("Hibernate get records of currency by period");
//            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
//            session.beginTransaction();
//
//            Query query = session.createQuery("FROM CurrencyEntity  WHERE exchangedate BETWEEN '" + date_from + "' AND '" + date_to + "'  ORDER BY exchangedate DESC");
//            List<CurrencyEntity> currencyList = query.list(); // or query.getResultList();
//
//            session.getTransaction().commit();
//            session.close();
//
//            return currencyList;
//
//        } catch (Exception e) {
//            System.out.println("Exception! Error message: " + e.getMessage());
//        }
//
//        return null;
//    }
//
//    // update
//    public boolean updateCurrency(CurrencyEntity currency) {
//        try {
//            System.out.println("Hibernate update record of currency");
//            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
//            session.beginTransaction();
//
//            session.update(currency);
//
//            session.getTransaction().commit();
//            session.close();
//
//            return true;
//        } catch (Exception e) {
//            System.out.println("Exception! Error message: " + e.getMessage());
//        }
//
//        return false;
//    }
//
//    // delete
//    public boolean deleteCurrency(CurrencyEntity currency) {
//        try {
//            System.out.println("Hibernate delete record of currency");
//            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
//            session.beginTransaction();
//
//            session.delete(currency);
//
//            session.getTransaction().commit();
//            session.close();
//
//            return true;
//        } catch (Exception e) {
//            System.out.println("Exception! Error message: " + e.getMessage());
//        }
//
//        return false;
//    }
}

