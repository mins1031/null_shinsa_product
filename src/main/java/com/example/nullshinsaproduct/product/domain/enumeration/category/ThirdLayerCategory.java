package com.example.nullshinsaproduct.product.domain.enumeration.category;

import lombok.Getter;

import java.util.Set;

@Getter
public enum ThirdLayerCategory {
    // ===== 아우터 =====
    HOOD_ZIP_UP("후드 집업", Set.of(SecondLayerCategory.OUTER), 30001),
    BLOUSON_MA1("블루종/MA-1", Set.of(SecondLayerCategory.OUTER), 30002),
    RADDER("레더/라이더스 재킷", Set.of(SecondLayerCategory.OUTER), 30003),
    PER("무스탕/퍼", Set.of(SecondLayerCategory.OUTER), 30004),
    TRUCKER("트러커 재킷", Set.of(SecondLayerCategory.OUTER), 30005),
    SUIT_BLAZER("수트/블레이저", Set.of(SecondLayerCategory.OUTER), 30006),
    CARDIGAN("가디건", Set.of(SecondLayerCategory.OUTER), 30007),
    ANORAK("아노락 재킷", Set.of(SecondLayerCategory.OUTER), 30008),
    FLEECE("플리스/뽀글이", Set.of(SecondLayerCategory.OUTER), 30009),
    TRAINING("트레이닝 재킷", Set.of(SecondLayerCategory.OUTER), 30010),
    STADIUM("스타디움 재킷", Set.of(SecondLayerCategory.OUTER), 30011),
    MID_SEASON_COAT("환절기 코트", Set.of(SecondLayerCategory.OUTER), 30012),
    WINTER_SINGLE_COAT("겨울 싱글 코트", Set.of(SecondLayerCategory.OUTER), 30013),
    WINTER_DOUBLE_COAT("겨울 더블 코트", Set.of(SecondLayerCategory.OUTER), 30014),
    WINTER_ETC_COAT("겨울 기타 코트", Set.of(SecondLayerCategory.OUTER), 30015),
    LONG_PADDING_HEAVY_OUTER("롱패딩/헤비 아우터", Set.of(SecondLayerCategory.OUTER), 30016),
    SHORT_PADDING_HEAVY_OUTER("숏패딩/헤비 아우터", Set.of(SecondLayerCategory.OUTER), 30017),
    PADDING_VEST("패딩 베스트", Set.of(SecondLayerCategory.OUTER), 30018),
    VEST("베스트", Set.of(SecondLayerCategory.OUTER), 30019),
    SAFARI_HUNTING("사파리/헌팅 재킷", Set.of(SecondLayerCategory.OUTER), 30020),
    NYLON_COACH("나일론/코치 재킷", Set.of(SecondLayerCategory.OUTER), 30021),
    ETC_OUTER("기타 아우터", Set.of(SecondLayerCategory.OUTER), 30022),


    // ===== 상의 =====
    SWEATSHIRT("맨투맨/스웨트", Set.of(SecondLayerCategory.TOP), 30023),
    SHIRT("셔츠/블라우스", Set.of(SecondLayerCategory.TOP), 30024),
    HOOD_T_SHIRT("후드 티셔츠", Set.of(SecondLayerCategory.TOP), 30025),
    KNIT("니트", Set.of(SecondLayerCategory.TOP), 30026),
    KARA_T_SHIRT("PK/카라 티셔츠", Set.of(SecondLayerCategory.TOP), 30027),
    LONG_SLEEVE("긴소매 티셔츠", Set.of(SecondLayerCategory.TOP), 30028),
    SHORT_SLEEVE("반소매 티셔츠", Set.of(SecondLayerCategory.TOP), 30029),
    SLEEVELESS("민소매 티셔츠", Set.of(SecondLayerCategory.TOP), 30030),
    ETC_TOP("기타 상의", Set.of(SecondLayerCategory.TOP), 30031),


    // ===== 하의 =====
    DENIM("데님 팬츠", Set.of(SecondLayerCategory.BOTTOM), 30032),
    COTTON("코튼 팬츠", Set.of(SecondLayerCategory.BOTTOM), 30033),
    SUIT_SLACKS("수트 팬츠/ 슬랙스", Set.of(SecondLayerCategory.BOTTOM), 30034),
    TRAINING_JOGGER("트레이닝/조거팬츠", Set.of(SecondLayerCategory.BOTTOM), 30035),
    SHORT("숏 팬츠", Set.of(SecondLayerCategory.BOTTOM), 30036),
    LEGGINGS("레깅스", Set.of(SecondLayerCategory.BOTTOM), 30037),
    JUMP("점프 슈트", Set.of(SecondLayerCategory.BOTTOM), 30038),
    ETC_BOTTOM("기타 하의", Set.of(SecondLayerCategory.BOTTOM), 30039),


    BACK_BAG("백팩", Set.of(SecondLayerCategory.BAG), 30040),
    CROSS_BAG("메신저/크로스백", Set.of(SecondLayerCategory.BAG), 30041),
    SHOULDER_BAG("숄더백", Set.of(SecondLayerCategory.BAG), 30042),
    TOT_BAG("토트백", Set.of(SecondLayerCategory.BAG), 30043),
    ECO_BAG("에코,컨버스백", Set.of(SecondLayerCategory.BAG), 30044),
    BOSTON_DUFFLE_BAG("보스턴/더플백", Set.of(SecondLayerCategory.BAG), 30045),
    WAIST_BAG("웨이스트백", Set.of(SecondLayerCategory.BAG), 30046),
    POUCH_BAG("파우치", Set.of(SecondLayerCategory.BAG), 30047),
    CARRIER("캐리어", Set.of(SecondLayerCategory.BAG), 30048),
    CLUTCH_BAG("클러치", Set.of(SecondLayerCategory.BAG), 30049),
    ETC_BAG("기타 가방", Set.of(SecondLayerCategory.BAG), 30050),

    // ===== 원피스/스커트 =====
    MINI_DRESS("미니 원피스", Set.of(SecondLayerCategory.DRESS_SKIRT), 30051),
    MIDI_DRESS("미디 원피스", Set.of(SecondLayerCategory.DRESS_SKIRT), 30052),
    MAXI_DRESS("맥시 원피스", Set.of(SecondLayerCategory.DRESS_SKIRT), 30053),
    MINI_SHIRT("미니 스커트", Set.of(SecondLayerCategory.DRESS_SKIRT), 30054),
    MIDI_SHIRT("미디 스커트", Set.of(SecondLayerCategory.DRESS_SKIRT), 30055),
    LONG_SHIRT("롱 스커트", Set.of(SecondLayerCategory.DRESS_SKIRT), 30056),


    // ===== 신발 =====
    SNEAKERS("스니커즈", Set.of(SecondLayerCategory.SHOES), 30057),
    SHOES("구두", Set.of(SecondLayerCategory.SHOES), 30058),
    SANDALS("샌달/슬리퍼", Set.of(SecondLayerCategory.SHOES), 30059),
    BOOTS("부츠/워커", Set.of(SecondLayerCategory.SHOES), 30060),
    SPORTS("스포츠화", Set.of(SecondLayerCategory.SHOES), 30061),
    SHOES_ACC("신발용품", Set.of(SecondLayerCategory.SHOES), 30062),
    PADDING_OR_PER("패딩/퍼 신발", Set.of(SecondLayerCategory.SHOES), 30063),


    // ===== 가전 =====
//    IMAGE_ELECTRONICS("영상가전", Set.of(SecondLayerCategory.ELECTRONICS), 30501),
//    KITCHEN_ELECTRONICS("주방가전", Set.of(SecondLayerCategory.ELECTRONICS), 30502),
//    WASHING_MACHINE_AND_DRYER("세탁기, 건조기", Set.of(SecondLayerCategory.ELECTRONICS), 30503),
//    VACUUM("청소기", Set.of(SecondLayerCategory.ELECTRONICS), 30504),
//    LIVING_ELECTRONICS("생활가전", Set.of(SecondLayerCategory.ELECTRONICS), 30505),
//    SEASON_ELECTRONICS("계절가전", Set.of(SecondLayerCategory.ELECTRONICS), 30506),
//    HEALTH_ELECTRONICS("건강가전", Set.of(SecondLayerCategory.ELECTRONICS), 30507),
//    REFURB("리퍼브", Set.of(SecondLayerCategory.ELECTRONICS), 30508),

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
