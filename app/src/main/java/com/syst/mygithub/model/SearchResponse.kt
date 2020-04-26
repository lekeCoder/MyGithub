package com.syst.mygithub.model

import com.google.gson.annotations.SerializedName

open class SearchResponse(
    @SerializedName("total_count") var totalCount: Int = 0,
    var items: List<Repository>? = null
)