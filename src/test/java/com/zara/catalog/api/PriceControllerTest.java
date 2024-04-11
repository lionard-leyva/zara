package com.zara.catalog.api;

import com.zara.catalog.api.application.PriceController;
import com.zara.catalog.api.domain.entity.Price;
import com.zara.catalog.api.domain.PriceSearchCriteria;
import com.zara.catalog.api.domain.services.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    private Price createTestPrice(BigDecimal priceValue) {
        return new Price(1L,
                1L,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                1,
                1L,
                1,
                priceValue,
                "EUR");
    }

    @Test
    void testGetPriceAt1000OnJune14() throws Exception {
        LocalDateTime testDateTime = LocalDateTime.of(2022, 6, 14, 10, 0);
        given(priceService.calculatePrice(new PriceSearchCriteria(35455L, 1L, testDateTime, testDateTime)))
                .willReturn(createTestPrice(new BigDecimal("35.50")));
        mockMvc.perform(get("/api/v1/prices/35455/1/" + testDateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(35.50)));
    }

    @Test
    void testGetPriceAt1600OnJune14() throws Exception {
        LocalDateTime testDateTime = LocalDateTime.of(2022, 6, 14, 16, 0);
        given(priceService.calculatePrice(new PriceSearchCriteria(35455L, 1L, testDateTime, testDateTime)))
                .willReturn(createTestPrice(new BigDecimal("25.45")));
        mockMvc.perform(get("/api/v1/prices/35455/1/" + testDateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(25.45)));
    }
    @Test
    void testGetPriceAt1000OnJune15() throws Exception {
        LocalDateTime testDateTime = LocalDateTime.of(2022, 6, 15, 10, 0);
        given(priceService.calculatePrice(new PriceSearchCriteria(35455L, 1L, testDateTime, testDateTime)))
                .willReturn(createTestPrice(new BigDecimal("30.50")));
        mockMvc.perform(get("/api/v1/prices/35455/1/" + testDateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(30.50)));
    }

    @Test
    void testGetPriceAt2100OnJune16() throws Exception {
        LocalDateTime testDateTime = LocalDateTime.of(2022, 6, 16, 21, 0);
        given(priceService.calculatePrice(new PriceSearchCriteria(35455L, 1L, testDateTime, testDateTime)))
                .willReturn(createTestPrice(new BigDecimal("38.95")));
        mockMvc.perform(get("/api/v1/prices/35455/1/" + testDateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(38.95)));
    }
    @Test
    void testGetPriceAt2100OnJune14() throws Exception {
        LocalDateTime testDateTime = LocalDateTime.of(2022, 6, 14, 21, 0);
        given(priceService.calculatePrice(new PriceSearchCriteria(35455L, 1L, testDateTime, testDateTime)))
                .willReturn(createTestPrice(new BigDecimal("25.45")));
        mockMvc.perform(get("/api/v1/prices/35455/1/" + testDateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(25.45)));
    }
}