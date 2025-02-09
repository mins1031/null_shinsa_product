package com.example.nullshinsaproduct.sale.application;

import com.example.nullshinsaproduct.sale.application.input.dto.request.SaleCommandRequest;
import com.example.nullshinsaproduct.sale.application.output.map.SaleOutputMapper;
import com.example.nullshinsaproduct.sale.application.output.port.SaleRepository;
import com.example.nullshinsaproduct.sale.domain.Sale;
import com.example.nullshinsaproduct.sale.domain.SaleStatus;
import com.example.nullshinsaproduct.sale.infrastructure.entity.SaleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;
    private final SaleInMemoryCache saleCache;

    @Transactional
    public void saveSale(final SaleCommandRequest req) {
        SaleEntity saleEntity = new SaleEntity(
                null,
                req.name(),
                req.salePercent(),
                SaleStatus.WAIT,
                req.startDateTime(),
                req.endDateTime()
        );

        saleRepository.save(saleEntity);
    }

    @Transactional
    public void updateSale(final long id, final SaleCommandRequest req) {
        Sale sale = SaleOutputMapper.toDomainFromEntity(
                saleRepository.findById(id)
        );

        sale.updateSale(
                req.name(),
                req.salePercent(),
                req.startDateTime(),
                req.endDateTime()
        );
        saleRepository.save(
                SaleOutputMapper.toEntityFromDomain(sale)
        );
    }

    @Transactional
    public void changeSaleStatus(final long id, final SaleStatus saleStatus) {
        Sale sale = SaleOutputMapper.toDomainFromEntity(
                saleRepository.findById(id)
        );

        sale.changeStatus(saleStatus);
        saleRepository.save(
                SaleOutputMapper.toEntityFromDomain(sale)
        );
    }

    @Transactional
    public void removeSale(final long id) {
        saleRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public void fineSale() {

    }
}
