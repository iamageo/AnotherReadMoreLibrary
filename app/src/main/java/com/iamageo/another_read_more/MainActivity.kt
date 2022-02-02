package com.iamageo.another_read_more

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.iamageo.library.AnotherReadMore


class MainActivity : AppCompatActivity() {

    private var anotherReadMore: AnotherReadMore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mtv = findViewById<TextView>(R.id.tv)

        anotherReadMore = AnotherReadMore.Builder(this).build()

        val readMoreOption: AnotherReadMore = AnotherReadMore.Builder(this)
            .textLength(100, AnotherReadMore.TYPE_LINE)
            .moreLabel("mais")
            .lessLabel("menos")
            .build()

        readMoreOption.addReadMoreTo(
            mtv,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        )
    }
}