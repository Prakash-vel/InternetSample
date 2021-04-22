package com.example.internetsample

import com.squareup.moshi.Json

data class QuotesProperty(

    @Json(name="text")
    val qoute: String,
    val author: String?
)
