package com.syst.mygithub.retrofit

import com.syst.mygithub.model.Profile
import com.syst.mygithub.model.Repository
import com.syst.mygithub.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface GitHubApiService {
    @GET("search/repositories")
    fun searchRepositories(@QueryMap options: Map<String, String>): Call<SearchResponse>

    @GET("users/{username}/repos")
    fun searchRepositoriesByUser(@Path("username") githubUser: String): Call<List<Repository>>

    @GET("users/{username}")
    fun gitProfile(@Path("username") githubUser: String): Call<Profile>
}