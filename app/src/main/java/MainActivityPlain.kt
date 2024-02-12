package ru.netology.nmedia.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import ru.netology.nmedia.R

class MainActivityPlain : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ImageButton>(R.id.like).setOnClickListener {
            if (it !is ImageButton) {
                return@setOnClickListener
            }

            it.setImageResource(R.drawable.ic_liked_24)
        }
    }
}