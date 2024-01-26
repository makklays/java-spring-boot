package org.example.services;

import com.zaxxer.hikari.HikariDataSource;
import org.example.domain.Currency;
import org.example.repository.CurrencyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.ValidationException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyServiceIntegrationTest {
    @Autowired
    private HikariDataSource dataSource;

    @Autowired
    private CurrencyService currencyService;

    @Test
    void getCurrencyByPeriod_If_have_response() throws ValidationException {
        String dateFrom = "2024-01-01";
        String dateTo = "2024-01-31";

        List<Currency> listCurrencies = currencyService.getCurrencyByPeriod(dateFrom, dateTo);

        //then
        assertEquals(1, listCurrencies.size());
    }
}
