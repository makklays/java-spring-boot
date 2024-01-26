package org.example.web.api;

import com.zaxxer.hikari.HikariDataSource;
import org.example.MyApplication;
import org.example.configuration.DataSourceConfiguration;
import org.example.domain.Currency;
import org.example.repository.CurrencyRepository;
import org.example.services.CurrencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.xml.bind.ValidationException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {MyApplication.class, DataSourceConfiguration.class})
@ActiveProfiles("test")
public class CurrencyControllerIntegrationTest {
    //
    private static Map<Integer, Currency> allCurrencies = new HashMap<>();

    @Autowired
    private HikariDataSource dataSource;

    private Currency currency;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyService currencyService;

    @BeforeEach
    public void setUp() throws Exception
    {
        currency = new Currency();
        currency.setR030("123");
        currency.setCc("USD");
        currency.setTxt("Американский долар");
        currency.setRate("12,12");
        currency.setIp("127.0.0.1");
        currency.setExchangedate(LocalDate.now());
    }

    @Test
    void CheckURLTest() throws ValidationException {
        // then
    }
}
