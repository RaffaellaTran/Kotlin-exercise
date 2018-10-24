package com.example.rafaellat.kotlinexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class DatabaseActivity {

    abstract fun addAddress(addressValue: String, cityValue: String)
    abstract fun deleteAddress(keyAddress: String)
    abstract fun showAddress(): LiveData<ArrayList<AddressModel>>

}
