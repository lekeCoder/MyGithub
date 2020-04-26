package com.syst.mygithub.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  GithubServiceClient {
    private val BASE_URL = "https://api.github.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val githubAPIService: GitHubApiService = retrofit.create(GitHubApiService::class.java)
}