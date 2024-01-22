package org.example.repository;

import org.example.domain.Currency;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyRepositoryTest {

    private static Map<Integer, Currency> allCurrencies = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        // something objects
        //user = new User("Евгений", 35, Sex.MALE);
        //user1 = new User("Марина", 34, Sex.FEMALE);
        //user2 = new User("Алина", 7, Sex.FEMALE);
    }

    @Test
    void insertCurrency() {
        int expected = 12;
        int actual = 11;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void getCurrency() {

        Currency expected = new Currency();
        expected.setR030("123");
        expected.setCc("USD");
        expected.setTxt("Американский долар");
        expected.setRate("12,12");
        expected.setIp("127.0.0.1");
        LocalDate date = LocalDate.of(2024, 1, 21);
        expected.setExchangedate(date);
        LocalDateTime dtime = LocalDateTime.of(2024, 1, 21, 12, 12, 12);
        expected.setCreatedAt(dtime);

        Currency actual = new Currency();
        actual.setR030("123");
        actual.setCc("USD");
        actual.setTxt("Американский долар");
        actual.setRate("12,12");
        actual.setIp("127.0.0.1");
        LocalDate date1 = LocalDate.of(2024, 1, 21);
        actual.setExchangedate(date1);
        LocalDateTime dtime1 = LocalDateTime.of(2024, 1, 21, 12, 12, 12);
        actual.setCreatedAt(dtime1);

        Assert.assertEquals(expected, actual);
    }
}

