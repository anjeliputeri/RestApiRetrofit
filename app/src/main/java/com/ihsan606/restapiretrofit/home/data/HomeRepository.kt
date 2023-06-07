package com.ihsan606.restapiretrofit.home.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ihsan606.restapiretrofit.network.ApiClient
import com.ihsan606.restapiretrofit.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeRepository {

    private var apiInterface:ApiInterface?=null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    fun fetchAllPosts():LiveData<List<PostModel>>{
        val data = MutableLiveData<List<PostModel>>()

        apiInterface?.fetchAllPosts()?.enqueue(object : Callback<List<PostModel>>{

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }

            }
        })

        if (data != null){
            println(data.value?.get(0)?.title)
        }

        return data

    }



}
