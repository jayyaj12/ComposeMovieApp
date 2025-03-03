package com.aos.domain.model

data class UiMovieListModel(
    val audiAcc: String, // 누적 관객수
    val audiChange: String, // 전일 대비 관객수 증감 비율
    val audiCnt: String, // 해당일 관객 수
    val movieCd: String, // 영화 코드
    val movieNm: String, // 영화명
    val openDt: String, // 개봉일
    val rank: String, // 순위
    val rankInten: String, // 순의 증감분
    val rankOldAndNew: String, // 신규진입 여부
    val rnum: String, // 순번
)
