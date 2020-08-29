package com.example.mvvm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.NumberPickerBindingAdapter.setValue
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.mvvm.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.reflect.Array.set


class MainActivity : AppCompatActivity() {

    var repo :Repository = Repository()


  // lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
      val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
      viewModel.UserData()
      val fetch = findViewById<Button>(R.id.btn_data)
      fetch.setOnClickListener() {
          viewModel.repo.balLiveData.observe(this, Observer<Resource<UserData>> {
              binding.balance = it.data
          })
      }

        //binding.tvAvg.text = "Vishnu"
       // viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
       // binding.viewmodel = viewModel
      //  binding.lifecycleOwner = this

        //binding.tvAvg.text = viewModel.average.value

      /*  val data = findViewById<Button>(R.id.btn_data)
        data.setOnClickListener {

            val baseApi = BaseApi()
            baseApi.getBalance().enqueueOnUIThread({

                Log.d("we", it?.avg_balance.toString())


                binding.tvAvg.text = it?.avg_balance.toString()
                binding.tvShare.text = it?.share.toString()
                binding.tvPeriod.text = it?.period.toString()
            },
                {

                },
                {

                }
            )

        }
      //  viewModel.liveData.observe(this, Observer<UserData>{ liveData -> // update UI })

       */

    }
}


