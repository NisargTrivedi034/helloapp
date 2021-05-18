package com.helloapp.activity

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.helloapp.R
import com.helloapp.adapter.HomePostAdapter
import com.helloapp.adapter.HomeUserStoryAdapter
import com.helloapp.databinding.ActivityHomeBinding
import com.helloapp.databinding.ActivityMainBinding
import com.helloapp.model.UserPost
import com.helloapp.model.Users
import com.helloapp.util.Utility


class test : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var userAdapter: HomeUserStoryAdapter
    lateinit var postAdapter: HomePostAdapter


    var usersList:MutableList<Users> = ArrayList()
    var usersPostList:MutableList<UserPost> = ArrayList()

    lateinit var users: Users
    lateinit var usersPost: UserPost

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.tvTag.setSelected(true)
        loadData()
        onClickListeners()
    }
    fun onClickListeners(){
        binding.imgOne.setOnClickListener({
            Utility.setSelectedMenu(Integer(1),binding.imgOne,binding.imgTwo,binding.imgThree,binding.imgFour,binding.imgFive)
        })
        binding.imgTwo.setOnClickListener({
            Utility.setSelectedMenu(Integer(2),binding.imgOne,binding.imgTwo,binding.imgThree,binding.imgFour,binding.imgFive)
        })
        binding.imgThree.setOnClickListener({
            Utility.setSelectedMenu(Integer(3),binding.imgOne,binding.imgTwo,binding.imgThree,binding.imgFour,binding.imgFive)
        })
        binding.imgFour.setOnClickListener({
            Utility.setSelectedMenu(Integer(4),binding.imgOne,binding.imgTwo,binding.imgThree,binding.imgFour,binding.imgFive)
        })
        binding.imgFive.setOnClickListener({
            Utility.setSelectedMenu(Integer(5),binding.imgOne,binding.imgTwo,binding.imgThree,binding.imgFour,binding.imgFive)
        })
    }
    fun loadData(){
        users = Users("Your Story")
        usersList.add(0,users)
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

        userAdapter = HomeUserStoryAdapter(this,usersList)
        binding.rvUsers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvUsers.adapter = userAdapter

        usersPost = UserPost("Priya","follow me on hello application","28 November 2020 at 10:45pm","#insta #model #likeforlike #followback #cute #beauty #comment #india")
        usersPostList.add(usersPost)
        usersPost = UserPost("Priya","follow me on hello application","28 November 2020 at 10:45pm","#insta #model #likeforlike #followback #cute #beauty #comment #india")
        usersPostList.add(usersPost)
        usersPost = UserPost("Priya","follow me on hello application","28 November 2020 at 10:45pm","#insta #model #likeforlike #followback #cute #beauty #comment #india")
        usersPostList.add(usersPost)
        usersPost = UserPost("Priya","follow me on hello application","28 November 2020 at 10:45pm","#insta #model #likeforlike #followback #cute #beauty #comment #india")
        usersPostList.add(usersPost)
        usersPost = UserPost("Priya","follow me on hello application","28 November 2020 at 10:45pm","#insta #model #likeforlike #followback #cute #beauty #comment #india")
        usersPostList.add(usersPost)

        postAdapter = HomePostAdapter(this,usersPostList)
        binding.rvPost.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvPost.adapter = postAdapter



    }

}