package com.syst.mygithub.activities.profile.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syst.mygithub.model.Profile
import com.syst.mygithub.model.Repository
import com.syst.mygithub.retrofit.GithubServiceClient
import com.syst.mygithub.utility.Utils
import com.syst.mygithub.utility.showLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel : ViewModel() {

    private lateinit var gitUser : String
    var profile: MutableLiveData<Profile>? = MutableLiveData()
    var repos : List<Repository> = mutableListOf()
    var mlRepos: MutableLiveData<List<Repository>>? = MutableLiveData(repos)
    private val githubServiceClient = GithubServiceClient.githubAPIService

    fun setGitUser(user: String) {
        gitUser = user
        getProfile()
    }

    fun getProfile() {
        Utils.showLog("Entered $gitUser", "ProfileViewModel getProfile()")
        githubServiceClient.gitProfile(gitUser).enqueue(object : Callback<Profile>{
            override fun onFailure(call: Call<Profile>, t: Throwable) {
                Utils.showLog("Get User Failed!!!", "ProfileViewModel getProfile()")
            }

            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                //Utils.showLog(response.message(), "ProfileViewModel getProfile()")
                if(response.isSuccessful){

                   response.body().let { profile?.value = it }
                    //Utils.showLog("Get User Success!!! ${response.body()}", "ProfileViewModel getProfile()")
                }
            }

        })
    }

    fun getPublicRepos(gitUser : String) {
        Utils.showLog("Entered $gitUser", "ProfileViewModel getPublicRepos()")
        githubServiceClient.searchRepositoriesByUser(gitUser).enqueue(object : Callback<List<Repository>>{

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                Utils.showLog("Get User Failed!!!", "ProfileViewModel")
            }

            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                if(response.isSuccessful){
                    mlRepos?.value = response.body()
                }
            }

        })
    }
}