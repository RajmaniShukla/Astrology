package com.app.dashboard.adapter

import Astrologer_profile
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.kotlinapi.R
import com.bumptech.glide.Glide

class AstroAdapter(var items: List<Astrologer_profile>, val applicationContext: Context) : RecyclerView.Adapter<AstroAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstroAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid,parent,false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
//        return 8
        return items.size
    }


    override fun onBindViewHolder(holder: AstroAdapter.ViewHolder, position: Int) {


        Glide.with(applicationContext).load(items.get(position).image).into(holder.profile_icon as ImageView)

        holder.itemView.setOnClickListener {
            Toast.makeText(applicationContext, "Test", Toast.LENGTH_LONG).show()

        }


        holder.profile_name?.text = items[position].user_name
        holder.experience_astro?.text= items[position].experience.toString()

        holder.CallRate?.text= "₹/ "+items[position].per_min_cost.toString()
        var rat=items.get(position).rating
        if (rat>4){
            holder.rating?.text= "*****"
        }else if(rat<4&& rat>3){
            holder.rating?.text= "****"
        }else if(rat<3&& rat>2){
            holder.rating?.text= "***"
        }
    }


    inner class ViewHolder(row: View):RecyclerView.ViewHolder(row) {

        var profile_icon: ImageView? = null
        var profile_name: TextView? = null
        var experience_astro: TextView? = null
        var CallRate: TextView? = null
        var rating: TextView? = null

        init {
            this.profile_icon = row.findViewById(R.id.profile_icon)
            this.profile_name = row.findViewById(R.id.profile_name)
            this.experience_astro = row.findViewById(R.id.experience_astro)
            this.CallRate = row.findViewById(R.id.CallRate)
            this.rating = row.findViewById(R.id.rating)

        }
    }


}