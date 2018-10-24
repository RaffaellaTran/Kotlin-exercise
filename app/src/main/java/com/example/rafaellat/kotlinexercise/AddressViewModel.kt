package com.example.rafaellat.kotlinexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddressViewModel: ViewModel() {

    var addressLifeData: MutableLiveData<List<String>>? = null

     fun loadAddress(): LiveData<ArrayList<AddressModel>> {

       return FirebaseSingleton.instance.showAddress()
    }
}
