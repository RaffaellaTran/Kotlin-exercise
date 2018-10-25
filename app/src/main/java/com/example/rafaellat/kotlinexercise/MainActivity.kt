package com.example.rafaellat.kotlinexercise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity(){

    private lateinit var aModel: AddressViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        aModel= ViewModelProviders.of(this).get(AddressViewModel::class.java)
        val addressData= aModel.loadAddress()
        val addressObserver = Observer<ArrayList<AddressModel>> { addressValue ->

            // Update the UI
            val adapter = AddressAdapter (this, addressValue)
            list_item.adapter = adapter

            // Delete touched item
            list_item.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
                FirebaseSingleton.instance.deleteAddress(addressValue[position].id)
            }
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        addressData.observe(this, addressObserver)

        //Create a new address
        fab.setOnClickListener {
            val createIntent= Intent (this@MainActivity, CreateAddressActivity::class.java)
            startActivity(createIntent)
        }
    }
}