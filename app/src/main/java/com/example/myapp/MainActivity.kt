package com.example.myapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val hashmap = HashMap<String, String>()
        hashmap.put("number", "+919876543212")

        val continueButton = findViewById<Button>(R.id.continue_button)

        // Set OnClickListener for the Button
        continueButton.setOnClickListener {
            try {
                val call = RetrofitClient.apiService.getOtp(hashmap)
                call.enqueue(object : Callback<GetOtpResponse> {
                    override fun onResponse(
                        call: Call<GetOtpResponse>,
                        response: Response<GetOtpResponse>
                    ) {
                        if (response.body() != null) {
                            Log.e("ResultMsz=?", response.body().toString())
                            val intent = Intent(this@MainActivity, EnterOtpActivity::class.java)
                            startActivity(intent)
                        } else {

                        }

                    }

                    override fun onFailure(call: Call<GetOtpResponse>, t: Throwable) {
                        Log.e("ErrorMsz==>", t.message.toString())
                    }
                })

            } catch (e: Exception) {
                Log.e("fsdf", e.message.toString())
                // Handle the error
            }
        }


    }
}