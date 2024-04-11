package com.zara.catalog.api.domain.services;

import com.zara.catalog.api.domain.entity.Price;
import com.zara.catalog.api.domain.PriceSearchCriteria;

public interface PriceService {
    Price calculatePrice(PriceSearchCriteria criteria);
}

