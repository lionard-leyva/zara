package com.zara.catalog.api.application;

import com.zara.catalog.api.domain.PriceSearchCriteria;
import com.zara.catalog.api.domain.entity.Price;
import com.zara.catalog.api.domain.response.PriceResponse;
import com.zara.catalog.api.domain.services.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controller class for prices operations.
 *
 * @author Lionard Leyva Hurtado
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/{productId}/{brandId}/{dateTime}")
    public ResponseEntity<PriceResponse> getPrice(@PathVariable Long productId,
                                                  @PathVariable Long brandId,
                                                  @PathVariable String dateTime) {
        LocalDateTime date = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
        PriceSearchCriteria criteria = new PriceSearchCriteria(productId, brandId, date, date);
        Price price = priceService.calculatePrice(criteria);
        PriceResponse response = new PriceResponse(price.productId(),
                price.brandId(),
                price.price(),
                price.curr(),
                price.startDate(),
                price.endDate());
        return ResponseEntity.ok(response);
    }
}