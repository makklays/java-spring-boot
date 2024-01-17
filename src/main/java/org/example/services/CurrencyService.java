package org.example.services;

import org.example.config.HibernateSessionFactoryConfiguration;
import org.example.domain.CurrencyEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class CurrencyService {

    public CurrencyService() {}

    // get records of currency by period
    public List<CurrencyEntity> getCurrencyByPeriod(String date_from, String date_to) {
        if (date_from.isEmpty()) date_from = "2024-01-08";
        if (date_to.isEmpty()) date_to = "2024-01-08";

        try {
            System.out.println("Hibernate get records of currency by period");
            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM CurrencyEntity WHERE exchangedate > " + date_from + " AND exchangedate < " + date_to + " ORDER BY exchangedate DESC");
            List<CurrencyEntity> currencyList = query.list(); // or query.getResultList();

            session.getTransaction().commit();
            session.close();

            return currencyList;

        } catch (Exception e) {
            System.out.println("Exception! Error message: " + e.getMessage());
        }

        return null;
    }

    // get records (logs) from database (table currencies)
    public boolean getCurrencyFromNationalBank(String code_currency) {
        System.setProperty("http.agent", "Chrome"); // "User-Agent", "Mozilla/5.0"
        System.setProperty("content-type", "application/json");
        System.setProperty("Accept", "application/json");
        try {
            URL url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=20240105&json");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host Name: " + url.getHost());
            System.out.println("Port Number: " + url.getPort());
            System.out.println("File Name: " + url.getFile());

            InputStreamReader urlInR = new InputStreamReader(url.openStream());
            BufferedReader buf = new BufferedReader(urlInR);

            String line;

            //--- Hibernate --------------
            System.out.println("Hibernate tutorial");
            Session session = HibernateSessionFactoryConfiguration.getSessionFactory().openSession();
            session.beginTransaction();

            StringBuilder b = new StringBuilder();
            while ((line = buf.readLine()) != null) {
                b.append(line);
            }

            JSONArray j = new JSONArray(b.toString());
            //System.out.println("Length: " + j.length() + " List: " + j.toList());
            for (int i=0; i < j.length(); i++) {

                JSONObject item = (JSONObject) j.get(i);

                if (item.has("r030")) {

                    Integer r030 = (Integer) item.get("r030");
                    String txt  = (String) item.get("txt");
                    String rate = (String) item.get("rate").toString();
                    String cc = (String) item.get("cc");
                    LocalDate edate = LocalDate.parse(item.get("exchangedate").toString(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                    if (Objects.equals(code_currency, cc)) {
                        CurrencyEntity cur = new CurrencyEntity();
                        cur.setR030(item.get("r030").toString());
                        cur.setTxt(item.get("txt").toString());
                        cur.setRate(item.get("rate").toString());
                        cur.setCc(item.get("cc").toString());
                        cur.setExchangedate(edate);
                        cur.setIp("127.0.0.1 :-)");

                        System.out.println("My currency: " + cur.toString());

                        session.save(cur);
                    }
                }
            }
            session.getTransaction().commit();
            session.close();
            //--- END Hibernate ----------

        } catch (Exception e) {
            System.out.println( "Exception! Error message: " + e.getMessage());
            System.out.println( "Exception! Error stack trace: " + e.getStackTrace());

            return false;
        }

        return true;
    }
}

