package com.example.rafaellat.kotlinexercise

import androidx.lifecycle.LiveData

abstract class Repository {

    abstract fun addAddress(addressValue: String, cityValue: String)
    abstract fun deleteAddress(keyAddress: String)
    abstract fun showAddress(): LiveData<ArrayList<AddressModel>>

}
