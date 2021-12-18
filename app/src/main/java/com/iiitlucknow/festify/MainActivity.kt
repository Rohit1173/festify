package com.iiitlucknow.festify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iiitlucknow.festify.Adapters.recyclerAdapter
import com.iiitlucknow.festify.Adapters.sliderAdapter
import com.iiitlucknow.festify.data.recyclerItem
import com.iiitlucknow.festify.databinding.ActivityMainBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sliderAdapter: sliderAdapter
    private var images: MutableList<Int> = mutableListOf(
        R.drawable.android_img,
        R.drawable.web_development_img,
        R.drawable.cybersecurity_img,
        R.drawable.ai_img,
        R.drawable.designing_img
    )
    private var fields: MutableList<recyclerItem> = mutableListOf(
        recyclerItem(R.drawable.android, R.string.android),
        recyclerItem(R.drawable.web_development, R.string.web),
        recyclerItem(R.drawable.cyber_security, R.string.cyber_sec),
        recyclerItem(R.drawable.ai, R.string.ai),
        recyclerItem(R.drawable.design, R.string.design)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        sliderAdapter = sliderAdapter(images)
        binding.apply {
            slide.setSliderAdapter(sliderAdapter)
            slide.setIndicatorAnimation(IndicatorAnimationType.WORM)
            slide.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
            slide.startAutoCycle()
            recycler.adapter = recyclerAdapter(fields)
            recycler.setHasFixedSize(true)
        }
    }
}