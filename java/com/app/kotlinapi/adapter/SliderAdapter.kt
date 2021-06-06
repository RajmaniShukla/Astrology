package com.app.dashboard.adapter

import Banner
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.kotlinapi.R
import com.bumptech.glide.Glide
class SliderAdapter(var items: List<Banner>,val mContext: Context) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slider_item,parent,false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: SliderAdapter.ViewHolder, position: Int) {
//        Glide.with(mContext).load(items.get(position).coupon_image).into(holder.imageSlider as ImageView)
        Glide.with(mContext).load(items.get(position).coupon_image).into(holder.imageSlider as ImageView)


        holder.itemView.setOnClickListener {
            Toast.makeText(mContext, "Test", Toast.LENGTH_LONG).show()

        }
    }
    inner class ViewHolder(row: View):RecyclerView.ViewHolder(row) {

        var imageSlider: ImageView? = null

        init {
            this.imageSlider = row.findViewById(R.id.slider_Image)

        }
    }


}

