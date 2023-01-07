package com.gigawattstechnology.smartnakakotlin.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gigawattstechnology.smartnakakotlin.*
import com.gigawattstechnology.smartnakakotlin.databinding.FragmentHomeBinding
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val vehiclePlateNumber=binding.EnterPlateNumber
        binding.CheckFeedData.setOnClickListener{
            val platenumber=vehiclePlateNumber.text.toString()
            if (platenumber.isEmpty()){
                vehiclePlateNumber.setError("Required Field")
                return@setOnClickListener
            }
            val filterDoc=FilterDoc(platenumber)
            val body=FindBody("Cluster0","MyDiaryDatabase","MyDiaryCollection",filterDoc)
            val apiInterface=RetrofitInstance.getRETROFIT()?.create(ApiInterface::class.java)
            apiInterface?.findTask(body)?.enqueue(object :Callback<JsonObject>{
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    if (response.body()!=null){
                        Log.d("resp",response.body().toString())
                        Toast.makeText(root.context,response.body().toString(),Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(root.context,"Error",Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    Toast.makeText(root.context,"Failure",Toast.LENGTH_SHORT).show()
                }

            })
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}