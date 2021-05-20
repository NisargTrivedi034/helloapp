package com.helloapp.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.helloapp.R
import com.helloapp.adapter.HomePostAdapter
import com.helloapp.adapter.HomeUserStoryAdapter
import com.helloapp.adapter.LanguageAdapter
import com.helloapp.databinding.ActivityMainBinding
import com.helloapp.databinding.ActivitySelectLanguageBinding
import com.helloapp.model.LanguageModel
import com.helloapp.model.UserPost
import com.helloapp.model.Users

class selectLenguage : SplashBaseActivity() {

    lateinit var binding: ActivitySelectLanguageBinding
    lateinit var language:LanguageModel
    lateinit var languageList:ArrayList<LanguageModel>
    lateinit var adapter: LanguageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_select_language)
        loadData()
    }
    fun loadData(){
        languageList=ArrayList<LanguageModel>()
        language = LanguageModel("English",R.drawable.ln_eng)
        languageList.add(language)
        language = LanguageModel("Gujarati",R.drawable.ln_guj)
        languageList.add(language)
        adapter = LanguageAdapter(this, languageList)
        binding.rvLanguage.layoutManager = GridLayoutManager(
            this, 2)
        binding.rvLanguage.adapter = adapter

    }
}