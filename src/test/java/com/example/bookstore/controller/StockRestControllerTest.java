package com.example.bookstore.controller;

import com.example.bookstore.model.Stock;
import com.example.bookstore.service.StockService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(StockRestController.class)
class StockRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StockService stockService;

    @Autowired
    private JacksonTester<List<Stock>> jacksonStock;

    @Test
    void shouldReturnAllStocks() throws Exception {
        Mockito.when(stockService.getAllStocks()).thenReturn(List.of(
           new Stock(0L, 10, true),
           new Stock(1L, 0, false)
        ));

        //when
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/stocks").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        //then
        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(
                jacksonStock.write(List.of(
                        new Stock(0L, 10, true),
                        new Stock(1L, 0, false))).getJson());
    }
}
