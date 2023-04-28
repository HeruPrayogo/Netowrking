package com.example.netowrking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.netowrking.databinding.ItemNewsBinding
import com.example.netowrking.model.DataFilmItem
import com.example.netowrking.model.ResponseDataNewsItem
//untuk menampilan datan list news memakai List<ResponseDataNewsItem>
class NewsAdapter(var listNews: List<DataFilmItem>  ) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.Judul.text = listNews[position].name
       holder.binding.Tanggal.text = listNews[position].date
       Glide.with(holder.itemView).load(listNews[position].image).into(holder.binding.imageView2)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }


}