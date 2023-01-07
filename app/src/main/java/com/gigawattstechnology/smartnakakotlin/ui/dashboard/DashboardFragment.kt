package com.gigawattstechnology.smartnakakotlin.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gigawattstechnology.smartnakakotlin.ApiInterface
import com.gigawattstechnology.smartnakakotlin.DataBody
import com.gigawattstechnology.smartnakakotlin.Doc
import com.gigawattstechnology.smartnakakotlin.RetrofitInstance
import com.gigawattstechnology.smartnakakotlin.databinding.FragmentDashboardBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val vehiclePlateNumber=binding.AddVehiclePlateNumber
        val vehicleHolderName=binding.AddVehicleHolderName
        val vehicleCompanyModal=binding.AddVehicleModal
        binding.AddToNakaDatabase.setOnClickListener {
            val platenumber=vehiclePlateNumber.text.toString()
            val holdername=vehicleHolderName.text.toString()
            val modalcompany=vehicleCompanyModal.text.toString()
            if(platenumber.isEmpty()){
                vehiclePlateNumber.setError("Required Field")
                return@setOnClickListener
            }
            if(holdername.isEmpty()){
                vehicleHolderName.setError("Required Field")
                return@setOnClickListener
            }
            if (modalcompany.isEmpty()){
                vehicleCompanyModal.setError("Required Field")
                return@setOnClickListener
            }
            val doc=Doc(platenumber,holdername,modalcompany)
            val body=DataBody("Cluster0","MyDiaryDatabase","MyDiaryCollection",doc)
            val apiInterface=RetrofitInstance.getRETROFIT()?.create(ApiInterface::class.java)
            apiInterface?.insertTask(body)?.enqueue(object :Callback<DataBody>{
                override fun onResponse(call: Call<DataBody>, response: Response<DataBody>) {
                    if (response.body()!=null){
                        Toast.makeText(root.context,"Update Success",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(root.context,"Error",Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<DataBody>, t: Throwable) {
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