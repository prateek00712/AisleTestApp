package com.example.myapp

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("users/phone_number_login")
    fun getOtp(@Body hashmap: HashMap<String, String>): Call<GetOtpResponse>

    @POST("users/verify_otp")
    fun otpVerification(
        @Body hashmap1: HashMap<String, String>
    ): Call<EnterOtpResponse>

    // New GET method
    @Headers("Authorization: 32c7794d2e6a1f7316ef35aa1eb34541")
    @GET("users/test_profile_list")
    fun getTestProfileList(): Call<TestProfileList>
}