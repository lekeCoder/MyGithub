package com.syst.mygithub.utility

import android.content.Context
import android.util.Log

object Utils {
    fun showLog(msg: String, tag:String = "MyGithub") {
        Log.e(tag,msg)
    }

}