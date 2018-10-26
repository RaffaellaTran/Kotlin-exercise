package com.example.rafaellat.kotlinexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import timber.log.Timber

internal class FirebaseService private constructor() : AddressModelType() {
    val database = FirebaseFirestore.getInstance()

    override fun addAddress(addressValue: String, cityValue: String) {

        val address = HashMap<String, String>()
        address["address"] = addressValue
        address["city"] = cityValue

        database.collection("addressList")
            .add(address as Map<String, Any>)
            .addOnSuccessListener { documentReference ->

                Timber.d("DocumentSnapshot added with ID: %s", documentReference.id)
            }
            .addOnFailureListener { e -> Timber.w(e, "Error adding document") }

    }

    override fun deleteAddress(keyAddress: String) {

        database.collection("addressList").document(keyAddress).delete()
        Timber.d("DocumentSnapshot deleted with ID: %s", keyAddress)

    }

    override fun showAddress(): LiveData<ArrayList<Address>> {
        val liveData = MutableLiveData<ArrayList<Address>>()
        database.collection("addressList").addSnapshotListener { querySnapshot, firebaseFirestoreException ->
            val docs = querySnapshot?.documents

            val addressList = ArrayList<Address>()
            docs?.forEach { address ->
                val addressModel = Address(
                    address["address"].toString(),
                    address["city"].toString(),
                    address.id
                )
                addressList.add(addressModel)
                Timber.d(address.data.toString())
            }
//            val addressList2 = docs?.map {address->
//                val addressModel = Address(
//                    address["address"].toString(),
//                    address["city"].toString(),
//                    address.id
//                )
//                addressModel
//            }

            liveData.value = addressList
        }
        return liveData
    }

    companion object {
        val instance = FirebaseService()

    }
}
