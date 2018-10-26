package com.example.rafaellat.kotlinexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class AddressViewModel : ViewModel() {

    val AddressModel = AddressModel()

    fun addAddress(addressValue: String, cityValue: String) {
        return AddressModel.addAddress(addressValue, cityValue)
    }

    fun address(): LiveData<ArrayList<Address>> {
        return AddressModel.showAddress()
    }
    fun deleteAddress(keyAddress: String){
        return AddressModel.deleteAddress(keyAddress)
    }
}
