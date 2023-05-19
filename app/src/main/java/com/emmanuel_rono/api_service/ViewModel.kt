package com.emmanuel_rono.api_service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emmanuel_rono.api_service.Network.Api
import kotlinx.coroutines.launch
class viewmodel:ViewModel()
{
    //Stores the data
    val the_Data= MutableLiveData<String>()
    //variable to access and update the data
    //This is an immutable variable-That means it can be change, as values comes in
    val data:LiveData<String> = the_Data

     //Init-> used to tell the compiler to run the /function first when class is accessed
    init {
        get_the_data()
    }
fun get_the_data() {
    //launch the viemodelScope
    viewModelScope.launch{
        try {
            val listResult = Api.retrofitService.getData()
            the_Data.value = "Success: ${listResult.length} Mars photos retrieved"
        } catch (e: Exception) {
            the_Data.value = "Failure: ${e.message}"
        }

    }
}
}