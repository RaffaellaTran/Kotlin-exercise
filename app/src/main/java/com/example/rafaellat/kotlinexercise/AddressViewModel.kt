package com.example.rafaellat.kotlinexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddressViewModel: ViewModel() {

    var addressLifeData: MutableLiveData<String>? = null

     fun loadAddress(): LiveData<String> {

       return FirebaseSingleton.instance.showAddress()
    }
}
