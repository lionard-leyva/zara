package com.zara.catalog.api;

import com.zara.catalog.api.domain.entity.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceTest {

    @Test
    public void testPriceThrowsExceptionWhenPriceIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Price(1L, 1L, LocalDateTime.now(),
                    LocalDateTime.now().plusDays(1), 1,
                    35455L, 1, BigDecimal.ZERO, "EUR");
        }, "El precio debe ser mayor que 0");
    }

    @Test
    public void testPriceThrowsExceptionWhenPriceIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Price(1L, 1L, LocalDateTime.now(),
                    LocalDateTime.now().plusDays(1), 1, 35455L,
                    1, new BigDecimal("-10"), "EUR");
        }, "El precio debe ser mayor que 0");
    }

    @Test
    public void testPriceThrowsExceptionWhenStartDateIsAfterEndDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Price(1L, 1L, LocalDateTime.now().plusDays(1),
                    LocalDateTime.now(), 1, 35455L,
                    1, new BigDecimal("20.00"), "EUR");
        }, "La fecha de inicio debe ser anterior a la fecha de fin");
    }

    @Test
    public void testPriceThrowsExceptionWhenStartDateIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Price(1L, 1L, null,
                    LocalDateTime.now().plusDays(1), 1, 35455L,
                    1, new BigDecimal("20.00"), "EUR");
        }, "Las fechas de inicio y fin no pueden ser nulas");
    }

    @Test
    public void testPriceThrowsExceptionWhenEndDateIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Price(1L, 1L, LocalDateTime.now(), null,
                    1, 35455L, 1, new BigDecimal("20.00"), "EUR");
        }, "Las fechas de inicio y fin no pueden ser nulas");
    }
}