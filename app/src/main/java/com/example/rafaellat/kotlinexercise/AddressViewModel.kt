package com.example.rafaellat.kotlinexercise

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddressViewModel: ViewModel() {

    var addressLifeData: MutableLiveData<List<String>>? = null

    fun getAddressList(keyAddress: String): MutableLiveData<List<String>>? {
        if (addressLifeData == null) {
           loadAddress(keyAddress)
        }

        return addressLifeData
    }

    private fun loadAddress(keyAddress: String) {

        val addressStringMap = mutableListOf("")
        addressStringMap.add(keyAddress)
        addressLifeData?.setValue(addressStringMap)
    }
}
