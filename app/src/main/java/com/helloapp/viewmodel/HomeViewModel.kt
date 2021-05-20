
package com.helloapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helloapp.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.RequestBody
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    var locationViewModel : MutableLiveData<String>? = null
    fun getName(data: RequestBody) : LiveData<String>{
        locationViewModel = HomeRepository.getLocation(data)
        return locationViewModel as MutableLiveData<String>
    }
}