package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.elite.auth.AuthException
import io.elite.core.Call

open class ApiBaseLiveData<T> : LiveData<T>() {
    private lateinit var apiCall: Call<*, *>
    protected fun <T> makeApiCall(
        apiCall: Call<T, AuthException>,
        data: MutableLiveData<Resource<T>>
    ): LiveData<Resource<T>> {
        data.value = Resource.loading()
        apiCall.enqueueOnUIThread({
            data.value = Resource.success(it)
        }, {
            data.value = Resource.failure(it)
        }, {
            data.value = Resource.noInternet()
        })
        return data
    }
}