package com.example.nullshinsaproduct.common.mail.listner;

import com.example.nullshinsaproduct.common.mail.EmailSender;
import com.example.nullshinsaproduct.product.application.event.ProductSaveEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductSaveEventListener {
    private final EmailSender emailSender;

    @EventListener
    public void listenEvent(ProductSaveEvent event) {
        log.info("ProductSaveEvent listen!  event : {}", event);

        String title = event.brandName() + "의 상품이 등록 되었습니다";
        String content = event.brandName() + "에서 신규 등록한 상품인";
        String content2 = event.productName() + "(상품번호 : " + event.productId() + ")" + "이(가) 등록 되었습니다";

        emailSender.send(
                title,
                List.of(content, content2),
                event.receiverEmail()
        );
    }
}
