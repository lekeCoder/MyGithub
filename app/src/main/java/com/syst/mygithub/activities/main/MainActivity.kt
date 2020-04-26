package com.syst.mygithub.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.syst.mygithub.R
import com.syst.mygithub.activities.profile.GithubProfileActivity
import com.syst.mygithub.utility.Constants
import com.syst.mygithub.utility.checkEditText
import com.syst.mygithub.utility.saveStr
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendButClick(view : View){
        if(githubUsername.checkEditText(txtLayout)){
            saveStr(Constants.GIT_USER, githubUsername.text.toString())
            val intent = Intent(this@MainActivity, GithubProfileActivity::class.java)
            intent.putExtra(GithubProfileActivity.GITUSER,githubUsername.text.toString())
            startActivity(intent)
        }
    }
}
