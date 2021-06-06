package com.app.kotlinapi.fragment

import Astrologer_profile
import Banner
import Json4Kotlin_Base
import Live_astrologer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.dashboard.adapter.AstroAdapter
import com.app.dashboard.adapter.LiveSessionAdapter
import com.app.dashboard.adapter.SliderAdapter
import com.app.kotlinapi.R
import com.app.kotlinapi.network.ApiInterface
import com.app.kotlinapi.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : Fragment() {

    private lateinit var sliderRecyclerview: RecyclerView
    private lateinit var liveRecyclerview: RecyclerView
    private lateinit var gridListRecyclerview: RecyclerView

    private lateinit var adapter: SliderAdapter
    private lateinit var liveSessionAdapter: LiveSessionAdapter
    private lateinit var astroAdapter: AstroAdapter

    lateinit  var sliderBanner: List<Banner>
    lateinit var itemProfile:List<Live_astrologer>
    lateinit var gridList:List<Astrologer_profile>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        sliderRecyclerview =view.findViewById(R.id.slider_recyclerview);
        liveRecyclerview =view.findViewById(R.id.live_session);
        gridListRecyclerview =view.findViewById(R.id.gridList);

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity)
        val linearLayoutManager2: LinearLayoutManager = LinearLayoutManager(activity)
        val linearLayoutManager3: GridLayoutManager = GridLayoutManager(activity,2)


        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        linearLayoutManager2.orientation = LinearLayoutManager.HORIZONTAL
        linearLayoutManager3.orientation = GridLayoutManager.VERTICAL


        sliderRecyclerview.layoutManager = linearLayoutManager
        liveRecyclerview.layoutManager = linearLayoutManager2
        gridListRecyclerview.layoutManager = linearLayoutManager3


        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        retIn.getUserData("90").enqueue(object :
            Callback<Json4Kotlin_Base> {
            override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {
                Toast.makeText(
                    activity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: Call<Json4Kotlin_Base>, response: Response<Json4Kotlin_Base>) {
//                response.body()?.data?.live_astrologer?.get(0)?.image?.let { Log.d("responseData", it) }
                sliderBanner= response.body()?.data?.banner!!
                itemProfile= response.body()?.data?.live_astrologer!!
                gridList= response.body()?.data?.astrologer_profile!!

                sliderRecyclerview.apply {
                    sliderRecyclerview.layoutManager
                    adapter= activity?.let { SliderAdapter(sliderBanner, it) }
                    sliderRecyclerview.adapter=adapter

                }
                liveRecyclerview.apply {
                    liveRecyclerview.layoutManager
                    liveSessionAdapter= activity?.let { LiveSessionAdapter(itemProfile, it) }!!
                    liveRecyclerview.adapter=liveSessionAdapter

                }

                gridList.apply {
                    gridListRecyclerview.layoutManager
                    astroAdapter= activity?.let { AstroAdapter(gridList, it) }!!
                    gridListRecyclerview.adapter=astroAdapter
                }

                Toast.makeText(activity, "Registration success!"+ (response.body()?.data?.astrologer_profile?.get(0)?.language
                        ), Toast.LENGTH_SHORT)
                    .show()
            }
        })

        return view;
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            Home().apply {

            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}