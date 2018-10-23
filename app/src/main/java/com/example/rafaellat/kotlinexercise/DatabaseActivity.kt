package com.example.rafaellat.kotlinexercise

abstract class DatabaseActivity {

    abstract fun addAddress(address: String, city: String)

    abstract fun deleteAddress(key: String)

}
