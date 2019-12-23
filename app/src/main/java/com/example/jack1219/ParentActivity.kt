package com.example.jack1219

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_parent.*
import okhttp3.*
import okhttp3.OkHttpClient
import java.io.IOException



class ParentActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
        supportActionBar?.hide()


        button_parent_arrow_left.setOnClickListener {
            var myIntent = Intent(this, SecondActivity::class.java)
            startActivity(myIntent)
        }

        //////

        val mContext :Context = this

        auth_button.setOnClickListener {
            /////connection

            val client = OkHttpClient()
            val url = "http://ec2-52-78-148-252.ap-northeast-2.compute.amazonaws.com/phone_auth"

            val requestBody: RequestBody =  FormBody.Builder()
                .add("phone_num", "01036153132")
                .add("device_token", "1")
                .add("os", "Android")
                .build()

            val request :Request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()

            client.newCall(request).enqueue(object: Callback{
                override fun onFailure(call: Call, e: IOException) {
                    println("API connection: fail")
                    //Toast.makeText(mContext, "인증번호 발송에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call, response: Response) {
                    println("API connection: OK")
                    //Toast.makeText(mContext, "인증번호가 발송되었습니다.", Toast.LENGTH_SHORT).show()

                }

            })

        }

    }
}