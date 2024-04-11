package com.zara.catalog.api.domain.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceResponse(Long productId,
                            Long brandId,
                            BigDecimal price,
                            String currency,
                            LocalDateTime startDate,
                            LocalDateTime endDate) {
}
