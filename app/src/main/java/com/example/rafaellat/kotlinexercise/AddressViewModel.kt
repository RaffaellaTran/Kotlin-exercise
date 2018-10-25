package com.example.rafaellat.kotlinexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class AddressViewModel: ViewModel() {

     fun loadAddress(): LiveData<ArrayList<AddressModel>> {

       return FirebaseSingleton.instance.showAddress()
    }
}
