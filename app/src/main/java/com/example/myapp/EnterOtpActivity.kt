package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnterOtpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.enter_otp_layout)

        val data = hashMapOf<String, String>()
        data["number"] = "+919876543212"
        data["otp"] = "1234"

        val continueButton = findViewById<Button>(R.id.continue_button_2)

        // Set OnClickListener for the Button
        continueButton.setOnClickListener {
            try {
                val call = RetrofitClient.apiService.otpVerification(data)
                call.enqueue(object : Callback<EnterOtpResponse> {
                    override fun onResponse(
                        call: Call<EnterOtpResponse>,
                        response: Response<EnterOtpResponse>
                    ) {
                        if (response.body() != null) {
                            Log.e("ResultMsz=?", response.body().toString())
                            val intent = Intent(this@EnterOtpActivity, NoteActivity::class.java)
                            startActivity(intent)

                        } else {

                        }

                    }

                    override fun onFailure(call: Call<EnterOtpResponse>, t: Throwable) {
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