package org.example.web.client;

import org.example.domain.Currency;
import org.example.repository.CurrencyRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
public class NationalBankClient {

    private static final Logger log = LoggerFactory.getLogger(NationalBankClient.class);

    private final CurrencyRepository currencyRepository;

    public NationalBankClient(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }


    public Currency getCurrencyFromNationalBank(String code_currency, String by_date) {
        Currency cur = new Currency();
        System.setProperty("http.agent", "Chrome"); // "User-Agent", "Mozilla/5.0"
        System.setProperty("content-type", "application/json");
        System.setProperty("Accept", "application/json");
        try {
            URL url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date="+by_date+"&json");
            log.info("Protocol:{} Host Name:{} Port Number:{} File Name:{}", url.getProtocol(), url.getHost(), url.getPort(), url.getFile());

            String text = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining());
            JSONArray jsonArray = new JSONArray(text);


            for (int i=0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String cc = (String) jsonObject.get("cc");
                    LocalDate edate = LocalDate.parse(jsonObject.get("exchangedate").toString(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                    if (code_currency.equals(cc)) {

                        cur.setR030(jsonObject.get("r030").toString());
                        cur.setTxt(jsonObject.get("txt").toString());
                        cur.setRate(jsonObject.get("rate").toString());
                        cur.setCc(jsonObject.get("cc").toString());
                        cur.setExchangedate(edate);
                        cur.setIp("127.0.0.1 :-)");

                        log.info("My currency: {}", cur);
                        currencyRepository.insertCurrency(cur);

                    }
                }

        } catch (Exception e) {
            log.error( "Exception! Error message: {}", e.getMessage());
            log.error( "Exception! Error stack trace: {}", e.getStackTrace());
        }

        return cur;
    }
}
