package com.example.mvvm

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import io.elite.auth.AuthException
import io.elite.auth.AuthResponseConverter
import io.elite.auth.AuthService
import io.elite.core.Call
import io.elite.core.Elite
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.lang.reflect.Type

class BaseApi {


    enum class ApiRequestType {
        POST, PUT, DELETE, GET
    }

    fun <T> mkCall(
        url: String,
        jsonBody: String,
        bodyType: Type,
        type: ApiRequestType,
        setRequestType: Boolean
    ): Call<T, AuthException> {
        Elite.instance.requestType = setRequestType
        val reqBody = jsonBody.toRequestBody(AuthService.JSON)
        var request: Request? = null
        val builder = Request.Builder()
            .url(url)
        if (type == ApiRequestType.POST) {
            request = builder.post(reqBody).build()
        } else if (type == ApiRequestType.PUT) {
            request = builder.put(reqBody).build()
        } else if (type == ApiRequestType.DELETE) {
            request = builder.delete(reqBody).build()
        } else if (type == ApiRequestType.GET) {
            request = builder.get().build()
        }
        return Call(
            Elite.instance.getAuth().client!!.newCall(request!!),
            AuthResponseConverter(bodyType)
        )
    }


    fun getBalance(): Call<UserData, AuthException> {

        val respType = object : TypeToken<UserData>() {
        }.type
        return BaseApi()
            .mkCall(
                "$masterUrl/balance", NO_JSON, respType, ApiRequestType.GET,
                AUTH_REQUIRED
            )

    }


    fun getHistory(): Call<DataHistory, AuthException> {

        val respType = object : TypeToken<DataHistory>() {
        }.type
        return BaseApi()
            .mkCall(
                "$masterUrl/history", NO_JSON, respType, ApiRequestType.GET,
                AUTH_REQUIRED
            )
    }


    companion object {

        val NO_JSON = ""
        val AUTH_NOT_REQUIRED = false
        val AUTH_REQUIRED = true

        /**
         * @variable Server Config
         * */

        val masterUrl = "https://5ec152876197530016092294.mockapi.io/api/hipbar/interview/1/"

        private val gson = GsonBuilder().create()
    }
}