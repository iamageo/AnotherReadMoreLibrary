package com.iamageo.another_read_more

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iamageo.another_read_more.`simple-adapter`.SimpleAnotherAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        -> THIS CODE FOR SIMPLE EXAMPLE

        val mtv = findViewById<TextView>(R.id.tv)

        val anotherReadMore: AnotherReadMore = AnotherReadMore.Builder(this)
            .textLength(100, AnotherReadMore.TYPE_LINE)
            .moreLabel("mais")
            .lessLabel("menos")
            .build()

        anotherReadMore.addReadMoreTo(
            mtv,
            getString(R.string.big_text)
        )

         */

        val recyclerView = findViewById<View>(R.id.mRecyclerView) as RecyclerView
        val mLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLayoutManager
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            mLayoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
        val mAdapter = SimpleAnotherAdapter(this)
        recyclerView.adapter = mAdapter

    }
}