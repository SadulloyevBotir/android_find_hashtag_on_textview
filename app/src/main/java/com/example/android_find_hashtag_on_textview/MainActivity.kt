package com.example.android_find_hashtag_on_textview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val tv_first = findViewById<TextView>(R.id.tv_first)
        val bn_search = findViewById<Button>(R.id.bn_search)

        bn_search.setOnClickListener {
            val pattern = Pattern.compile("(#\\w+)")
            val matcher = pattern.matcher(tv_first.text)

            while (matcher.find()) {
                val spannableStr = SpannableString(tv_first.text)
                val foregroundColorSpan = ForegroundColorSpan(Color.GREEN)
                spannableStr.setSpan(
                    foregroundColorSpan,
                    matcher.start(),
                    matcher.end(),
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE
                )
                tv_first.text = spannableStr
            }
        }
    }
}