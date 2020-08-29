package com.example.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.databinding.ActivityMainBinding
import io.elite.core.noInternetConnection

class MainViewModel():ViewModel() {

    var repo :Repository= Repository()


    fun UserData(){
        repo.getBalance()
    }

   /* var average = MutableLiveData<String>()
    var share = MutableLiveData<String>()
    var period = MutableLiveData<String>()

    var error = MutableLiveData<String>()

    var history = MutableLiveData<String>()

    var bankname = MutableLiveData<String>()
    var amount = MutableLiveData<String>()
    var card = MutableLiveData<String>()

    //var error :String = ""
    //MutableLiveData<Resource<String>>()

    val baseApi = BaseApi()

    fun onClickBalance(){
        baseApi.getBalance().enqueueOnUIThread({
          //  Log.d("we", it?.avg_balance.toString())
            average.value = it?.avg_balance.toString()
            share.value = it?.share.toString()
            period.value = it?.period.toString()
        },
            {
                error.value = it.errorResponse.toString()
            },
            {
                error.value ="No Internet"
            }
        )
    }


    fun onClickHistory(){
        baseApi.getHistory().enqueueOnUIThread({
            //  Log.d("we", it?.avg_balance.toString())
          history.value = it?.num?.size.toString()
        },
            {
                error.value = it.errorResponse.toString()
            },
            {
                error.value ="No Internet"
            }
        )
    }

     // val projectListObservable: LiveData<List<UserData>>? = null

    */
}

