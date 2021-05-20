package com.helloapp.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.helloapp.R
import com.helloapp.adapter.HomePostAdapter
import com.helloapp.adapter.HomeUserStoryAdapter
import com.helloapp.databinding.ActivityMainBinding
import com.helloapp.model.UserPost
import com.helloapp.model.Users
import com.helloapp.security.Crypto
import com.helloapp.util.Utility
import com.helloapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONException
import org.json.JSONObject
import javax.inject.Inject





class test : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var userAdapter: HomeUserStoryAdapter
    lateinit var postAdapter: HomePostAdapter


    var usersList:MutableList<Users> = ArrayList()
    var usersPostList:MutableList<UserPost> = ArrayList()

    lateinit var users: Users
    lateinit var usersPost: UserPost

    lateinit var homeViewModel:HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        load()


        binding.tvTag.setSelected(true)

        loadData()
        onClickListeners()


//        homeViewModel.getName(postData!!).observe(this,{
//        })
    }
    fun onClickListeners(){
        binding.imgOne.setOnClickListener {
            Utility.setSelectedMenu(
                    1,
                    binding.imgOne,
                    binding.imgTwo,
                    binding.imgThree,
                    binding.imgFour,
                    binding.imgFive
            )
        }
        binding.imgTwo.setOnClickListener {
            Utility.setSelectedMenu(
                    2,
                    binding.imgOne,
                    binding.imgTwo,
                    binding.imgThree,
                    binding.imgFour,
                    binding.imgFive
            )
        }
        binding.imgThree.setOnClickListener {
            Utility.setSelectedMenu(
                    3,
                    binding.imgOne,
                    binding.imgTwo,
                    binding.imgThree,
                    binding.imgFour,
                    binding.imgFive
            )
        }
        binding.imgFour.setOnClickListener {
            Utility.setSelectedMenu(
                    4,
                    binding.imgOne,
                    binding.imgTwo,
                    binding.imgThree,
                    binding.imgFour,
                    binding.imgFive
            )
        }
        binding.imgFive.setOnClickListener {
            Utility.setSelectedMenu(
                    5,
                    binding.imgOne,
                    binding.imgTwo,
                    binding.imgThree,
                    binding.imgFour,
                    binding.imgFive
            )
        }
    }
    fun loadData(){
        users = Users("Your Story")
        usersList.add(0, users)
        users = Users("Martin")
        usersList.add(users)
        users = Users("Ricky")
        usersList.add(users)
        users = Users("Martin")
        usersList.add(users)
        users = Users("Ricky")
        usersList.add(users)
        users = Users("Martin")
        usersList.add(users)

        userAdapter = HomeUserStoryAdapter(this, usersList)
        binding.rvUsers.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.rvUsers.adapter = userAdapter

        usersPost = UserPost(
            "Priya",
            "follow me on hello application",
            "28 November 2020 at 10:45pm",
            "#insta #model #likeforlike #followback #cute #beauty #comment #india"
        )
        usersPostList.add(usersPost)
        usersPost = UserPost(
            "Priya",
            "follow me on hello application",
            "28 November 2020 at 10:45pm",
            "#insta #model #likeforlike #followback #cute #beauty #comment #india"
        )
        usersPostList.add(usersPost)
        usersPost = UserPost(
            "Priya",
            "follow me on hello application",
            "28 November 2020 at 10:45pm",
            "#insta #model #likeforlike #followback #cute #beauty #comment #india"
        )
        usersPostList.add(usersPost)
        usersPost = UserPost(
            "Priya",
            "follow me on hello application",
            "28 November 2020 at 10:45pm",
            "#insta #model #likeforlike #followback #cute #beauty #comment #india"
        )
        usersPostList.add(usersPost)
        usersPost = UserPost(
            "Priya",
            "follow me on hello application",
            "28 November 2020 at 10:45pm",
            "#insta #model #likeforlike #followback #cute #beauty #comment #india"
        )
        usersPostList.add(usersPost)

        postAdapter = HomePostAdapter(this, usersPostList)
        binding.rvPost.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.rvPost.adapter = postAdapter



    }
    fun load(){
        val jRequest = JSONObject()
        try {
            jRequest.put("sortingType", "0")
            jRequest.put("languageId", "2")
            jRequest.put("UserID", "0")
            jRequest.put("pageStart", "1")
            jRequest.put("pageSize", "40")

        } catch (e1: JSONException) {
            e1.printStackTrace()
        }
        var postData : RequestBody? = null
        try {
            postData = Crypto.Encrypt(jRequest.toString(), this).toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.getName(postData!!).observe(this, { res ->
            var response = Crypto.Decrypt(res.toString(), this)
            Log.d("Response--->", response.toString())
        })
    }

}