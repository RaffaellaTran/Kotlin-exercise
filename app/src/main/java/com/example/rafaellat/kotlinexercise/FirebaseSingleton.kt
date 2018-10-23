package com.example.rafaellat.kotlinexercise

import android.util.Log
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.reflect.Field
import com.google.firebase.firestore.CollectionReference



internal class FirebaseSingleton private constructor() : DatabaseActivity() {
    val database = FirebaseFirestore.getInstance()
    var TAG = "MESSAGE"
    var i=0

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

    fun showData(){
        database.collection("addressList")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d(TAG, document.id + " => " + document.data)
                    }
                } else {
                    Log.w(TAG, "Error getting documents.", task.exception)
                }
            }
    }

    companion object {
        val instance = FirebaseSingleton()
    }
}
