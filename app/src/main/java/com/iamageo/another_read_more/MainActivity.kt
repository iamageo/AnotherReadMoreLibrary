package com.iamageo.another_read_more

import SimpleAnotherAdapter
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iamageo.another_read_more.databinding.ActivityMainBinding
import com.iamageo.library.AnotherReadMore


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBasicView()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val mLayoutManager = LinearLayoutManager(this)
        binding.mRecyclerView.layoutManager = mLayoutManager
        val dividerItemDecoration = DividerItemDecoration(
            binding.mRecyclerView.context,
            mLayoutManager.orientation
        )
        binding.mRecyclerView.addItemDecoration(dividerItemDecoration)
        val mAdapter = SimpleAnotherAdapter(this)
        binding.mRecyclerView.adapter = mAdapter
    }

    private fun setupBasicView() {
        val anotherReadMore: AnotherReadMore = AnotherReadMore.Builder()
            .textLength(3, AnotherReadMore.TextLengthType.TYPE_LINE)
            .moreLabel("mais")
            .lessLabel("menos")
            .build()

        anotherReadMore.addReadMoreTo(
            binding.tv,
            getString(R.string.big_text)
        )
    }
}