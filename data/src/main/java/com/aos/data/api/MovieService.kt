package com.aos.data.api

import com.aos.data.entity.movie_list.GetMovieListEntity
import com.aos.util.NetworkState
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getMovieList(
        @Query("targetDt") targetDate: String
    ): NetworkState<GetMovieListEntity>

}