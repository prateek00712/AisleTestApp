package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoteActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        val image_2 = findViewById<ImageView>(R.id.image_2)
        val image = findViewById<ImageView>(R.id.image_1)
        val image_3 = findViewById<ImageView>(R.id.image_3)
        val username_2 = findViewById<TextView>(R.id.username_2)
        val username_3 = findViewById<TextView>(R.id.username_3)
        val username = findViewById<TextView>(R.id.username)

        try {
            val call = RetrofitClient.apiService.getTestProfileList()
            call.enqueue(object : Callback<TestProfileList> {
                override fun onResponse(
                    call: Call<TestProfileList>,
                    response: Response<TestProfileList>
                ) {
                    if (response.body() != null) {
                        Log.e("ResultMsz=?", response.body().toString())

                        //setting image for swipe
                        Glide.with(this@NoteActivity).load(response.body()!!.invites.profiles.get(0).photos.get(0).photo)
                            .into(image)
                        username.setText("${response.body()!!.invites.profiles.get(0).general_information.first_name}")


                        //Setting images for like
                        Glide.with(this@NoteActivity).load(response.body()!!.likes.profiles.get(0).avatar)
                            .apply(RequestOptions.bitmapTransform(BlurTransformation())).into(image_2)
                        username_2.setText("${response.body()!!.likes.profiles.get(0).first_name}")
                        Glide.with(this@NoteActivity).load(response.body()!!.likes.profiles.get(1).avatar)
                            .apply(RequestOptions.bitmapTransform(BlurTransformation())).into(image_3)
                        username_3.setText("${response.body()!!.likes.profiles.get(1).first_name}")

                    } else {

                    }

                }

                override fun onFailure(call: Call<TestProfileList>, t: Throwable) {
                    Log.e("ErrorMsz==>", t.message.toString())
                }
            })

        } catch (e: Exception) {
            Log.e("fsdf", e.message.toString())
            // Handle the error
        }
    }
}