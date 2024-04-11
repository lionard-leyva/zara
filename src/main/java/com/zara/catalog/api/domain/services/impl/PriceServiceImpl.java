package com.zara.catalog.api.domain.services.impl;

import com.zara.catalog.api.domain.entity.Price;
import com.zara.catalog.api.domain.PriceSearchCriteria;
import com.zara.catalog.api.domain.exception.PriceCalculationException;
import com.zara.catalog.api.infraestructure.PriceRepository;
import com.zara.catalog.api.domain.services.PriceService;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price calculatePrice(PriceSearchCriteria criteria) {
        try {
            return priceRepository.findPricesByCriteria(criteria)
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new PriceCalculationException("No matching price found"));
        } catch (Exception e) {
            throw new PriceCalculationException("Error calculating price", e);
        }
    }
}