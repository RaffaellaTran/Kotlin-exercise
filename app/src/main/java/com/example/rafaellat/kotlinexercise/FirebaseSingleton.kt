package com.example.rafaellat.kotlinexercise

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

internal class FirebaseSingleton private constructor() : DatabaseActivity() {
    val database = FirebaseFirestore.getInstance()
    var TAG = "ADDRESS MESSAGE"

    override fun addAddress(addressValue: String, cityValue: String) {

        val address = HashMap<String, String>()
        address.put ("address", addressValue)
        address.put ("city", cityValue)

        database.collection("addressList")
            .add(address as Map<String, Any>)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    TAG,
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            }
            .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e) }
    }

    override fun deleteAddress(keyAddress: String) {

        database.collection("addressList").document(keyAddress).delete()

    }

    override fun showAddress(): LiveData<String> {
        var liveData = MutableLiveData<String>()
        database.collection("addressList").addSnapshotListener { querySnapshot, firebaseFirestoreException ->
            val docs = querySnapshot?.documents

            if (docs != null) {
                for (address in docs){
                    Log.d(
                        TAG, address.data.toString()
                    )
                }
                liveData.value = docs[0].data.toString()
            }
        }
        return liveData
    }

    companion object {
        val instance = FirebaseSingleton()
    }
}
