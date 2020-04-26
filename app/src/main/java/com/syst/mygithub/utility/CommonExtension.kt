package com.syst.mygithub.utility

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

fun Context.toast(msg:String, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, msg, length).show()
}

fun Context.showLog(msg:String) {
    Log.e(this.javaClass.simpleName, msg)
}

internal fun Context.getSharedPref(): SharedPreferences {
    return getSharedPreferences(Constants.SP_NAME, Context.MODE_PRIVATE)
}

fun Context.saveStr(key:String, value:String){
    val sp = getSharedPref()
    val editor = sp.edit()
    editor.putString(key,value)
    editor.apply()
}

fun Context.getStr(key:String): String {
    return getSharedPref().getString(key, "") ?: ""
}

fun EditText.checkEditText(textInputLayout: TextInputLayout) : Boolean {
    if(this.text.toString().isEmpty()){
        textInputLayout.error = "Cannot be empty"
        return false
    }
    textInputLayout.isErrorEnabled = false
    return true
}