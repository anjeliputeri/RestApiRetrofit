package com.ihsan606.restapiretrofit.network

import com.ihsan606.restapiretrofit.home.data.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun fetchAllPosts(): Call<List<PostModel>>
}