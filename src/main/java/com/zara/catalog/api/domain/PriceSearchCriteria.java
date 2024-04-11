package com.zara.catalog.api.domain;

import java.time.LocalDateTime;

public record PriceSearchCriteria
        (Long productId,
         Long brandId,
         LocalDateTime startDate,
         LocalDateTime endDate) {}
