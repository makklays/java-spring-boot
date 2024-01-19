package org.example.domain.animals;

import org.example.repository.CurrencyRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.example.domain.CurrencyEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

/**
 * Class: Currency
 * Description: This bean have several functions for currency.
 */
@Component
public class Currency {
    private String currency_code = "USD";

    public void setCurrencyCode(String currency_code) {
        this.currency_code = currency_code;
    }
    public String getCurrencyCode() {
        return this.currency_code;
    }

    public String searchRate(String currency_code, String by_date) {
        // validate
        if (currency_code.isEmpty()) {
            currency_code = "USD";
        }
        if (by_date.isEmpty()) {
            by_date = "20240108";
        }

        // log
        Logger logger = LoggerFactory.getLogger(Currency.class);

        // 1. connect and get data from National Bank
        System.setProperty("http.agent", "Mozilla/5.0");
        System.setProperty("content-type", "application/json");
        System.setProperty("Accept", "application/json");
        try {
            URL url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date="+by_date+"&valcode="+currency_code+"json");
            logger.info("Protocol: " + url.getProtocol());
            logger.info("Host Name: " + url.getHost());
            logger.info("Port Number: " + url.getPort());
            logger.info("File Name: " + url.getFile());

            InputStreamReader urlInR = new InputStreamReader(url.openStream());
            BufferedReader buffReader = new BufferedReader(urlInR);
            StringBuilder buff = new StringBuilder();
            String line;
            while ((line = buffReader.readLine()) != null) {
                buff.append(line);
            }
            JSONArray json_result = new JSONArray(buff.toString());
            logger.info("Result from URL of National Bank, Length: " + json_result.length() + " List: " + json_result.toList());

            // 2. add data to database (table=currency)
            for (int i = 0; i < json_result.length(); i++) {
                JSONObject item = (JSONObject) json_result.get(i);

                if (item.has("r030")) {
                    CurrencyEntity cur = new CurrencyEntity();
                    cur.setR030(item.get("r030").toString());
                    cur.setTxt(item.get("txt").toString());
                    cur.setRate(item.get("rate").toString());
                    cur.setCc(item.get("cc").toString());
                    LocalDate date1 = LocalDate.of(2024, 1, 8); // How get currently date?
                    cur.setExchangedate(date1);
                    cur.setIp("127.0.0.1"); // :-)

                    logger.info(cur.toString());

                    // insert
//                    CurrencyRepository curRepo = new CurrencyRepository();
//                    boolean res = curRepo.insertCurrency(cur);
//
//                    if (res) {
//                        logger.info("Inserted successfully record to `currencies`. Data: " + cur.toString());
//                    } else {
//                        logger.info("Not inserted record to `currencies`. Data: " + cur.toString());
//                    }

                    // array of objects for return
                    //List<CurrencyEntity> currEntity = ;
                }
            }
        } catch (Exception e) {
            logger.info("Exception! Bean " + Currency.class + ". Exception message: " + e.getMessage());
        }

        // 3. return data as json
        /*JSONObject json = new JSONObject();
        json.put("name", "jon doe");
        json.put("age", "22");*/

        // return currEntity; // ?
        return "100";
    }
}

