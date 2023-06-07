package com.ihsan606.restapiretrofit.home.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ihsan606.restapiretrofit.home.data.HomeRepository
import com.ihsan606.restapiretrofit.home.data.PostModel

class HomeViewModel(application: Application): AndroidViewModel(application) {

    private var homeRepository: HomeRepository?=null
    var postModelListLiveData : LiveData<List<PostModel>>?=null

    init {
        homeRepository = HomeRepository()
        postModelListLiveData = MutableLiveData()
    }

    fun fetchAllPosts(){
        postModelListLiveData = homeRepository?.fetchAllPosts()
    }
}