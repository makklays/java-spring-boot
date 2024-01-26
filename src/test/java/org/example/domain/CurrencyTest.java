package org.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class CurrencyTest {

    public static final LocalDateTime DATE_TIME = LocalDateTime.of(2024, 1, 21, 12, 12, 12);
    @Test
    public void testGettersAndSetters() {
        Currency currency = new Currency();

        // Test setters
        currency.setId(1);
        currency.setR030("123");
        currency.setTxt("USD");
        currency.setRate("1.0");
        currency.setCc("USD");
        currency.setExchangedate(LocalDate.now());
        currency.setIp("127.0.0.1");
        currency.setCreatedAt(DATE_TIME);

        // Test getters
        Assertions.assertEquals(1, currency.getId());
        Assertions.assertEquals("123", currency.getR030());
        Assertions.assertEquals("USD", currency.getTxt());
        Assertions.assertEquals("1.0", currency.getRate());
        Assertions.assertEquals("USD", currency.getCc());
        Assertions.assertEquals(LocalDate.now(), currency.getExchangedate());
        Assertions.assertEquals("127.0.0.1", currency.getIp());
        Assertions.assertEquals(DATE_TIME, currency.getCreatedAt());
    }

    @Test
    public void testEqualsAndHashCode() {
        Currency currency1 = new Currency();
        currency1.setId(1);
        currency1.setR030("123");
        currency1.setTxt("USD");
        currency1.setRate("1.0");
        currency1.setCc("USD");
        currency1.setExchangedate(LocalDate.now());
        currency1.setIp("127.0.0.1");
        currency1.setCreatedAt(DATE_TIME);

        Currency currency2 = new Currency();
        currency2.setId(1);
        currency2.setR030("123");
        currency2.setTxt("USD");
        currency2.setRate("1.0");
        currency2.setCc("USD");
        currency2.setExchangedate(LocalDate.now());
        currency2.setIp("127.0.0.1");
        currency2.setCreatedAt(DATE_TIME);

        Currency currency3 = new Currency();
        currency3.setId(2);
        currency3.setR030("456");
        currency3.setTxt("EUR");
        currency3.setRate("1.2");
        currency3.setCc("EUR");
        currency3.setExchangedate(LocalDate.now());
        currency3.setIp("192.168.0.1");
        currency3.setCreatedAt(DATE_TIME);

        // Test equals
        Assertions.assertEquals(currency1, currency2);
        Assertions.assertNotEquals(currency1, currency3);

        // Test hashCode
        Assertions.assertEquals(currency1.hashCode(), currency2.hashCode());
        Assertions.assertNotEquals(currency1.hashCode(), currency3.hashCode());
    }

    @Test
    void testToString() {
        Currency currency = new Currency();
        currency.setId(1);
        currency.setR030("123");
        currency.setTxt("USD");
        currency.setRate("1.0");
        currency.setCc("USD");
        currency.setExchangedate(LocalDate.now());
        currency.setIp("127.0.0.1");
        currency.setCreatedAt(DATE_TIME);

        String expectedToString = "Currency {" +
                "id=1" +
                ", r030='123'" +
                ", txt='USD'" +
                ", rate='1.0'" +
                ", cc='USD'" +
                ", exchangedate='" + LocalDate.now() + "'" +
                ", ip='127.0.0.1'" +
                ", created_at='" + DATE_TIME +
                "'}";

        Assertions.assertEquals(expectedToString, currency.toString());
    }
}