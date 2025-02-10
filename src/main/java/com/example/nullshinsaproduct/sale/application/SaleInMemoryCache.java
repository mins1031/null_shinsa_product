package com.example.nullshinsaproduct.sale.application;

import com.example.nullshinsaproduct.sale.application.output.map.SaleOutputMapper;
import com.example.nullshinsaproduct.sale.application.output.port.SaleRepository;
import com.example.nullshinsaproduct.sale.domain.Sale;
import com.example.nullshinsaproduct.sale.domain.SaleCacheKey;
import com.example.nullshinsaproduct.sale.infrastructure.entity.SaleEntity;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@Component
@RequiredArgsConstructor
public class SaleInMemoryCache {
    private final SaleRepository saleRepository;
    private Map<SaleCacheKey, PriorityQueue<Sale>> saleCacheMap = new HashMap<>();

    @PostConstruct
    public void initSaleInMemoryCache() {
        List<SaleEntity> allSaleByOnSale = this.saleRepository.findAllSaleByOnSale();
        allSaleByOnSale.forEach(sale ->
            this.upsertSale(SaleOutputMapper.toDomainFromEntity(sale))
        );
    }

    public void upsertSale(Sale sale) {
        SaleCacheKey key = SaleCacheKey.of(sale.getSalePercent(), sale.getStartDateTime(), sale.getId());
        PriorityQueue<Sale> values = saleCacheMap.getOrDefault(key, new PriorityQueue<>());
        values.remove(sale);
        values.add(sale);

        saleCacheMap.put(key, values);
    }

    public void removeSale(Sale sale) {
        SaleCacheKey key = SaleCacheKey.of(sale.getSalePercent(), sale.getStartDateTime(), sale.getId());
        PriorityQueue<Sale> values = saleCacheMap.getOrDefault(key, new PriorityQueue<>());
        values.remove(sale);
    }

//    public Sale findSale(Sale sale) {
//        SaleCacheKey key = SaleCacheKey.of(sale.getSalePercent(), sale.getStartDateTime(), sale.getId());
//        PriorityQueue<Sale> sales = saleCacheMap.get(key);
//
//    }
}
