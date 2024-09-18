package com.example.nullshinsaproduct.presentation;

import com.example.nullshinsaproduct.application.product.service.ProductFindService;
import com.example.nullshinsaproduct.domain.dto.response.ProductOptionStockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductFindController {
    private final ProductFindService productFindService;

    //TODO 보통 url 설계시 저렇게 integration 이라는 네이밍 적용이 자연스러울까요? 상품-상품옵션 데이터를 통합해 응답하는 api라서 저렇게 네이밍했는데 부자연스러울지 판단이 안서네요
    //TODO 컨트롤러단에는 문서관련 어노테이션을 제외하고 추가적인 설정이 필요없을까요?
    //TODO ResponseEntity가 장기적으로 봤을떄 사용하는게 괜찮을지 의문입니다. 차라리 별개의 공통Response 클래스로 통신하는건 어떤가 싶습니다
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/products/integration/{id}")
//    public ProductResponse findIntegrationProduct(@PathVariable("id") Long productId) {
//        return productFindService.findIntegrationProductById(productId);
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products/stock")
    public List<ProductOptionStockResponse> findProductOptionStock(@RequestParam(name = "productIds") List<Long> productOptionIdList) {
        return productFindService.findProductOptionStocks(productOptionIdList);
    }
}
