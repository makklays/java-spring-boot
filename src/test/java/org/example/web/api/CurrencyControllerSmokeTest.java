package org.example.web.api;

import org.example.services.CurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CurrencyControllerSmokeTest {
    //
    /*@Autowired
    private CurrencyController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }*/

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService service;

    @Test
    void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    void currencyShouldReturnListCurrencyFromService() throws Exception {

        // how correct ?
        // .thenReturn("List <Currency> t")

        //when(service.getCurrencyByPeriod("2024-01-01", "2024-01-31")).thenReturn("List <Currency> t");
        this.mockMvc.perform(get("/logs/2024-01-01/2024-01-31")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mock")));
    }
}

