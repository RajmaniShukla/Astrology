package com.app.dashboard.adapter

import Live_astrologer
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.kotlinapi.R
import com.bumptech.glide.Glide


class LiveSessionAdapter(var items: List<Live_astrologer>, val mContext: Context) : RecyclerView.Adapter<LiveSessionAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveSessionAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_livesession,parent,false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: LiveSessionAdapter.ViewHolder, position: Int) {

        Glide.with(mContext).load(items.get(position).image).into(holder.profile_image as ImageView)


    }
    inner class ViewHolder(row: View):RecyclerView.ViewHolder(row) {

        var profile_image: ImageView? = null

        init {
            this.profile_image = row.findViewById(R.id.profile_image)

        }
    }


}