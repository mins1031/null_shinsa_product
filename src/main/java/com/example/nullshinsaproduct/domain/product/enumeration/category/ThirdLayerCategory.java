package com.example.nullshinsaproduct.domain.product.enumeration.category;

import lombok.Getter;

import java.util.Set;

@Getter
public enum ThirdLayerCategory {
    // ===== 공통 =====
    OVERSEA_BRAND("해외브랜드", Set.of(SecondLayerCategory.CLOTHES, SecondLayerCategory.BAG, SecondLayerCategory.SHOES, SecondLayerCategory.ACC), 30001),
    ETC_ACC("기타 엑세서리", Set.of(SecondLayerCategory.ACC), 30002),

    // ===== 의류 =====
    OUTER("아우터", Set.of(SecondLayerCategory.CLOTHES), 30101),
    TOP("상의", Set.of(SecondLayerCategory.CLOTHES), 30102),
    BOTTOM("하의", Set.of(SecondLayerCategory.CLOTHES), 30103),
    SET_UP("셋업", Set.of(SecondLayerCategory.CLOTHES), 30104),
    HOME_WEAR("홈웨어", Set.of(SecondLayerCategory.CLOTHES), 30105),
    INNER_WEAR("이너웨어", Set.of(SecondLayerCategory.CLOTHES), 30106),
    DRESS("원피스", Set.of(SecondLayerCategory.CLOTHES), 30107),
    SKIRT("스커트", Set.of(SecondLayerCategory.CLOTHES), 30108),
    JUNP_SUIT("점프수트", Set.of(SecondLayerCategory.CLOTHES), 30109),
    ACTIVE_WEAR("엑티브웨어", Set.of(SecondLayerCategory.CLOTHES), 30110),
    KNIT_WEAR("니트웨어", Set.of(SecondLayerCategory.CLOTHES), 30111),

    // ===== 가방 =====
    TOT_BAG("토트백", Set.of(SecondLayerCategory.BAG), 30201),
    WAIST_BAG("웨이스트백", Set.of(SecondLayerCategory.BAG), 30202),
    CROSS_BAG("크로스백", Set.of(SecondLayerCategory.BAG), 30203),
    BACK_BAG("백팩", Set.of(SecondLayerCategory.BAG), 30204),
    SHOULDER_BAG("숄더백", Set.of(SecondLayerCategory.BAG), 30205),
    LAPTOP_BAG("랩탑백", Set.of(SecondLayerCategory.BAG), 30206),
    ECO_BAG("에코,컨버스백", Set.of(SecondLayerCategory.BAG), 30207),
    CLUTCH_BAG("클러치", Set.of(SecondLayerCategory.BAG), 30208),
    POUCH_BAG("파우치", Set.of(SecondLayerCategory.BAG), 30209),
    ETC_BAG("기타 가방", Set.of(SecondLayerCategory.BAG), 30210),

    // ===== 신발 =====
    SNEAKERS("스니커즈", Set.of(SecondLayerCategory.SHOES), 30301),
    ROPER("로퍼", Set.of(SecondLayerCategory.SHOES), 30302),
    SHOES("구두", Set.of(SecondLayerCategory.SHOES), 30303),
    BOOTS("부츠", Set.of(SecondLayerCategory.SHOES), 30304),
    SANDALS("샌달", Set.of(SecondLayerCategory.SHOES), 30305),
    SHOES_ACC("슈즈 액세서리", Set.of(SecondLayerCategory.SHOES), 30306),

    // ===== 액세서리 =====
    WALLET_CARD_CASE("지갑,카드케이스", Set.of(SecondLayerCategory.ACC), 30400),
    EYE_WEAR("아이웨어", Set.of(SecondLayerCategory.ACC), 30401),
    WATCH("시계", Set.of(SecondLayerCategory.ACC), 30402),
    HAT("모자", Set.of(SecondLayerCategory.ACC), 30403),
    NECK_TIE("넥타이", Set.of(SecondLayerCategory.ACC), 30404),
    BELT("벨트", Set.of(SecondLayerCategory.ACC), 30405),
    SOX("양말", Set.of(SecondLayerCategory.ACC), 30406),
    SCARP("스카프", Set.of(SecondLayerCategory.ACC), 30407),
    MUFFLER("머플러", Set.of(SecondLayerCategory.ACC), 30408),
    NECK_WARMER("넥워머", Set.of(SecondLayerCategory.ACC), 30409),
    GLOVES("장갑", Set.of(SecondLayerCategory.ACC), 30410),
    JEWELRY("주얼리", Set.of(SecondLayerCategory.ACC), 30411),

    // ===== 가전 =====
    IMAGE_ELECTRONICS("영상가전", Set.of(SecondLayerCategory.ELECTRONICS), 30501),
    KITCHEN_ELECTRONICS("주방가전", Set.of(SecondLayerCategory.ELECTRONICS), 30502),
    WASHING_MACHINE_AND_DRYER("세탁기, 건조기", Set.of(SecondLayerCategory.ELECTRONICS), 30503),
    VACUUM("청소기", Set.of(SecondLayerCategory.ELECTRONICS), 30504),
    LIVING_ELECTRONICS("생활가전", Set.of(SecondLayerCategory.ELECTRONICS), 30505),
    SEASON_ELECTRONICS("계절가전", Set.of(SecondLayerCategory.ELECTRONICS), 30506),
    HEALTH_ELECTRONICS("건강가전", Set.of(SecondLayerCategory.ELECTRONICS), 30507),
    REFURB("리퍼브", Set.of(SecondLayerCategory.ELECTRONICS), 30508),

    ;

    private final String desc;
    private final Set<SecondLayerCategory> upperCategories;
    private final int code;

    ThirdLayerCategory(String desc, Set<SecondLayerCategory> upperCategories,int code) {
        this.desc = desc;
        this.upperCategories = upperCategories;
        this.code = code;
    }
}
