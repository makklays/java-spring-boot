package org.example.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.example.MyApplication;
import org.example.configuration.DataSourceConfiguration;
import org.example.domain.Currency;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.example.domain.CurrencyTest.DATE_TIME;
import static org.junit.jupiter.api.Assertions.*;

import javax.xml.bind.ValidationException;

@SpringBootTest(classes = {MyApplication.class, DataSourceConfiguration.class})
@ActiveProfiles("test")
class CurrencyRepositoryIntegrationTest {

    private static Map<Integer, Currency> allCurrencies = new HashMap<>();

    @Autowired
    private HikariDataSource dataSource;
    private Currency currency;

    @Autowired
    private CurrencyRepository currencyRepository;

    @BeforeEach
    public void setUp() throws Exception {
        currency = new Currency();
        currency.setR030("123");
        currency.setCc("USD");
        currency.setTxt("Американский долар");
        currency.setRate("12,12");
        currency.setIp("127.0.0.1");
        currency.setExchangedate(LocalDate.now());
    }

    @Test
    void insertCurrency_If_proper_iserted() throws ValidationException {
        //before
        currency.setCreatedAt(DATE_TIME);
        currencyRepository.insertCurrency(currency);

        //then
        assertEquals(1, currencyRepository.getAllCurrencies().size());
    }

    @Test
    void getCurrency_Exception_If_NotValid_Field() {
        //then
        Assertions.assertThrows(ValidationException.class, () -> {
            currencyRepository.insertCurrency(currency);
        });
    }

    @Test
    void getCurrency() throws ValidationException {
        //before
        currency.setCreatedAt(DATE_TIME);
        currencyRepository.insertCurrency(currency);

        //then
        Currency currencyFromDb = currencyRepository.getCurrency("USD").get(0);
        Currency expected = new Currency();
        expected.setR030("123");
        expected.setCc("USD");
        expected.setTxt("Американский долар");
        expected.setRate("12,12");
        expected.setIp("127.0.0.1");
        expected.setExchangedate(LocalDate.now());
        expected.setCreatedAt(DATE_TIME);


        org.assertj.core.api.Assertions.assertThat(currencyFromDb).isEqualToIgnoringGivenFields(expected, "id");
    }

    @AfterEach
    void tearDown() {
        currencyRepository.deleteAllCurrencies();
    }
}

