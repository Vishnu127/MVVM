package com.example.mvvm

import android.app.Application
import io.elite.auth.AuthException
import io.elite.auth.AuthResponseConverter
import io.elite.auth.AuthService.Companion.JSON
import io.elite.core.Call
import io.elite.core.Elite
import io.elite.core.Environment
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.lang.reflect.Type

public class APIApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Elite.instance.context(applicationContext)
            .environment(Environment.DEV).authUrl("").authIdentifier("Bearer ")
            .useRole("user")
            .appName("").timeOut(5).build()

    }
}

