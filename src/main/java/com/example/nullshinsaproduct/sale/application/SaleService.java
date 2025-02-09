package com.example.nullshinsaproduct.sale.application;

import com.example.nullshinsaproduct.sale.application.input.dto.request.SaleCommandRequest;
import com.example.nullshinsaproduct.sale.application.output.map.SaleOutputMapper;
import com.example.nullshinsaproduct.sale.application.output.port.SaleRepository;
import com.example.nullshinsaproduct.sale.domain.Sale;
import com.example.nullshinsaproduct.sale.domain.SaleStatus;
import com.example.nullshinsaproduct.sale.infrastructure.entity.SaleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;

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

    public void changeSaleStatus(final long id, final SaleStatus saleStatus) {
        Sale sale = SaleOutputMapper.toDomainFromEntity(
                saleRepository.findById(id)
        );

        sale.changeStatus(saleStatus);
        saleRepository.save(
                SaleOutputMapper.toEntityFromDomain(sale)
        );
    }

    public void removeSale(final long id) {
        saleRepository.deleteById(id);
    }

    public void fineSale() {

    }
}
