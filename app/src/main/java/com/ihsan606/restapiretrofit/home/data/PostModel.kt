package com.ihsan606.restapiretrofit.home.data

data class PostModel(
    val userId: Int?= 0,
    var id:Int?=0,
    var title:String?="",
    var body:String?=""
)