package com.ihsan606.restapiretrofit.home.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ihsan606.restapiretrofit.R
import com.ihsan606.restapiretrofit.home.data.PostModel
import com.ihsan606.restapiretrofit.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vm:HomeViewModel
    private lateinit var adapter: HomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        initAdapter()

        vm.fetchAllPosts()

        vm.postModelListLiveData?.observe(this, Observer {
            if(it != null){
                rv_home.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<PostModel>)
            }else{

            }
        })

    }

    private fun initAdapter() {
        adapter = HomeAdapter()
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = adapter
    }

    private fun showToast(msg:String){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }
}