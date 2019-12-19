package com.example.jack1219


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_parent.*
import kotlinx.android.synthetic.main.activity_second.*

class ParentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
        supportActionBar?.hide()

        button_parent_arrow_left.setOnClickListener(
            {
                var myIntent = Intent(this, SecondActivity::class.java)
                startActivity(myIntent)}
        )
        auth_button.setOnClickListener(
            {
                var received_parent_phone = parent_phone.text.toString()
            }
        )
    }

}