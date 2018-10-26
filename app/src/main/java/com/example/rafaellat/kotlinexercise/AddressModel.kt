package com.example.rafaellat.kotlinexercise

import androidx.lifecycle.LiveData

abstract  class AddressModelType {
    abstract fun addAddress(addressValue: String, cityValue: String)
    abstract fun deleteAddress(keyAddress: String)
    abstract fun showAddress(): LiveData<ArrayList<Address>>
}
class AddressModel :AddressModelType(){

    override fun addAddress(addressValue: String, cityValue: String){
        return FirebaseService.instance.addAddress(addressValue, cityValue)
    }

    override fun showAddress(): LiveData<ArrayList<Address>> {
        return FirebaseService.instance.showAddress()
    }

    override fun deleteAddress(keyAddress: String){
        return FirebaseService.instance.deleteAddress(keyAddress)
    }
}