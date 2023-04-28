package com.example.netowrking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netowrking.databinding.ActivityMainBinding
import com.example.netowrking.model.DataFilmItem
import com.example.netowrking.model.ResponseDataNewsItem
import com.example.netowrking.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    fun getData(){
        //memakai callback yang retrofit
        RetrofitClient.instance.getAllNews().enqueue(object : Callback<List<DataFilmItem>>{
            override fun onResponse(
                //untuk response data news
                //call: Call<List<ResponseDataNewsItem>>,
                // response: Response<List<ResponseDataNewsItem>>
                call: Call<List<DataFilmItem>>,
                response: Response<List<DataFilmItem>>
            ) {
                if (response.isSuccessful){
                    binding.rvcon.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    binding.rvcon.adapter = NewsAdapter(response.body()!!)
                }else{
                    Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
                }
            }


            override fun onFailure(call: Call<List<DataFilmItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
            }

        })
    }
}