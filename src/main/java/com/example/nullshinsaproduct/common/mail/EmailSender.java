package com.example.nullshinsaproduct.common.mail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailSender {
    private final MailSender mailSender;

    public void send(
            String title,
            List<String> contents,
            List<String> receivers
    ) {
        log.info("mail send! title : {}, contents : {}, receivers : {}", title, contents, receivers);
    }
}
