package com.helloapp.activity

import android.R.attr.button
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.helloapp.R
import com.helloapp.databinding.SplashTwoBinding


class Splash_two : SplashBaseActivity() {
    lateinit var binding:SplashTwoBinding
    var i = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this, R.layout.splash_two)

        onClick()
    }
    //All Click set here
    private fun onClick() {
        //Next Button Click
        binding.btnNext.setOnClickListener {
            i++
            when (i) {
                0 -> {
                    binding.rl.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.s_two))
                    binding.imgLeft.visibility = View.VISIBLE
                    binding.imgRight.visibility = View.VISIBLE

                    binding.title.visibility = View.GONE
                    binding.desc.visibility = View.GONE


                }
                1 -> {
                    binding.rl.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.s_three))
                    binding.imgLeft.visibility = View.VISIBLE
                    binding.imgRight.visibility = View.VISIBLE
                    binding.title.visibility = View.GONE
                    binding.desc.visibility = View.GONE

                }
                2 -> {
                    binding.rl.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.s_four))
                    binding.imgLeft.visibility = View.VISIBLE
                    binding.imgRight.visibility = View.VISIBLE
                    binding.title.visibility = View.GONE
                    binding.desc.visibility = View.GONE

                }
                3 -> {
                    binding.rl.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.s_five))
                    binding.imgLeft.visibility = View.INVISIBLE
                    binding.imgRight.visibility = View.INVISIBLE
                    binding.title.visibility = View.VISIBLE
                    binding.desc.visibility = View.VISIBLE
                    binding.title.text = resources.getText(R.string.splash_six)


                }
                4 -> {
                    binding.rl.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.s_six))
                    binding.imgLeft.visibility = View.INVISIBLE
                    binding.imgRight.visibility = View.INVISIBLE
                    binding.title.visibility = View.VISIBLE
                    binding.desc.visibility = View.VISIBLE
                    binding.title.text = resources.getText(R.string.splash_seven)
                }
                5 -> {
                    binding.rl.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.s_seven))
                    binding.imgLeft.visibility = View.INVISIBLE
                    binding.imgRight.visibility = View.INVISIBLE
                    binding.title.visibility = View.VISIBLE
                    binding.desc.visibility = View.GONE
                    binding.title.text = resources.getText(R.string.splash_eight)
                    binding.btnNext.visibility = View.GONE
                    binding.btnStart.visibility = View.VISIBLE
                    binding.btnSkip.visibility = View.GONE
                }
            }
        }
        binding.btnStart.setOnClickListener {
            finish()
            val mainIntent = Intent(this, selectLenguage::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(mainIntent)
        }
    }
}


