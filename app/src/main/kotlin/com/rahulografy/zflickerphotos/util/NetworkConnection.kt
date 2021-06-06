package com.rahulografy.zflickerphotos.util

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.rahulografy.zflickerphotos.util.Constants.Network.Api.API_BASE_URL
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

// var isAppOnline = true

private const val TAG = "NetworkConnection"

fun isAppOnline(context: Context?): Boolean {
    val service = Context.CONNECTIVITY_SERVICE
    val manager = context?.getSystemService(service) as ConnectivityManager?
    val network = manager?.activeNetworkInfo
    Log.d(TAG, "isAppOnline: ${(network != null)}")
    return (network?.isConnected) ?: false
}

fun isServerUp(context: Context): Boolean {
    if (isAppOnline(context)) {
        try {
            val connection = URL(API_BASE_URL).openConnection() as HttpURLConnection
            connection.setRequestProperty("User-Agent", "Test")
            connection.setRequestProperty("Connection", "close")
            connection.connectTimeout = 10000
            connection.connect()
            Log.d(TAG, "isServerUp(): ${(connection.responseCode == 200)}")
            return (connection.responseCode == 200)
        } catch (e: IOException) {
            Log.e(TAG, "Error checking internet connection", e)
        }
    } else {
        Log.w(TAG, "Server is unavailable!")
    }
    Log.d(TAG, "isServerUp(): false")
    return false
}
