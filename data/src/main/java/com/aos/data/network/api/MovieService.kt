package com.aos.data.network.api

import com.aos.data.entity.movie_detail.GetMovieDetailEntity
import com.aos.data.entity.movie_list.GetMovieListEntity
import com.aos.data.network.state.NetworkState
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getMovieList(
        @Query("targetDt") targetDate: String
    ): NetworkState<GetMovieListEntity>

    @GET("movie/searchMovieInfo.json")
    suspend fun getMovie(
        @Query("movieCd") movieCd: String
    ): NetworkState<GetMovieDetailEntity>

}