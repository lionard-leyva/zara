package com.zara.catalog.api.infraestructure;

import com.zara.catalog.api.domain.entity.Price;
import com.zara.catalog.api.domain.PriceSearchCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("SELECT p FROM Price p WHERE p.productId = :#{#criteria.productId} " +
            "AND p.brandId = :#{#criteria.brandId} " +
            "AND p.startDate <= :#{#criteria.endDate} " +
            "AND p.endDate >= :#{#criteria.startDate} " +
            "ORDER BY p.priority DESC")
    List<Price> findPricesByCriteria(@Param("criteria") PriceSearchCriteria criteria);
}
