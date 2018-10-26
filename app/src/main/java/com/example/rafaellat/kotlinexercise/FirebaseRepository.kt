package com.example.rafaellat.kotlinexercise

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

internal class FirebaseRepository private constructor() : Repository() {
    val database = FirebaseFirestore.getInstance()

    override fun addAddress(addressValue: String, cityValue: String) {

        val address = HashMap<String, String>()
        address["address"] = addressValue
        address["city"] = cityValue

        database.collection("addressList")
            .add(address as Map<String, Any>)
            .addOnSuccessListener { documentReference ->
<<<<<<< HEAD
                Timber.d("DocumentSnapshot added with ID: %s", documentReference.id)
            }
            .addOnFailureListener { e -> Timber.w(e, "Error adding document") }
=======
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.id)
            }
            .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e) }
>>>>>>> parent of 71b48c8... add Timber and replace logs with Timber
    }

    override fun deleteAddress(keyAddress: String) {

        database.collection("addressList").document(keyAddress).delete()
<<<<<<< HEAD
        Timber.d("DocumentSnapshot deleted with ID: %s", keyAddress)
=======
>>>>>>> parent of 71b48c8... add Timber and replace logs with Timber

    }

    override fun showAddress(): LiveData<ArrayList<AddressModel>> {
        val liveData = MutableLiveData<ArrayList<AddressModel>>()
        database.collection("addressList").addSnapshotListener { querySnapshot, firebaseFirestoreException ->
            val docs = querySnapshot?.documents

            val addressList = ArrayList<AddressModel>()
            docs?.forEach { address ->
                val addressModel = AddressModel(
                    address["address"].toString(),
                    address["city"].toString(),
                    address.id
                )
                addressList.add(addressModel)
                Log.d(TAG + "2", address.data.toString())
            }
//            val addressList2 = docs?.map {address->
//                val addressModel = AddressModel(
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
        val instance = FirebaseRepository()
        const val TAG = "ADDRESS MESSAGE"

    }
}
