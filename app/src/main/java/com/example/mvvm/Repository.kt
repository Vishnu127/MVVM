package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.reflect.TypeToken
import io.elite.auth.AuthException
import io.elite.core.Call

class Repository :ApiBaseLiveData<Any>(){

    var balLiveData = MutableLiveData<Resource<UserData>>()

    fun getBalance():LiveData<Resource<UserData>>{
        return makeApiCall(getBalanceApi(),balLiveData)
    }

}

fun Repository.getBalanceApi() : Call<UserData,AuthException>{
    val respType = object : TypeToken<UserData>() {
    }.type
    return BaseApi()
        .mkCall(
            "${BaseApi.masterUrl}/balance", BaseApi.NO_JSON, respType, BaseApi.ApiRequestType.GET,
            BaseApi.AUTH_REQUIRED
        )
}
