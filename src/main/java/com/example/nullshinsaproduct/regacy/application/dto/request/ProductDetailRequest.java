package com.example.nullshinsaproduct.regacy.application.dto.request;

public record ProductDetailRequest (
        String manufacturingCountry, // 제조국
        String manufacturingCompany, // 제조국
        String manufacturingDate, // 제조일자
        String qualityGuarantee, // 품질보증기준
        String fabric, // 원단
        String measurement, // 치수
        String washCaution, // 세탁시 주의사항
        String productInnerItems, // 상품구성 내용
        String asOfficerAndTel, // as 담당자 및 번호
        String detailContent, // 상품상세 알림메모
        String brandDetailContent, // 브랜드 알림메모
        String adminDetailContent // 관리자 알림메모
) {
}
