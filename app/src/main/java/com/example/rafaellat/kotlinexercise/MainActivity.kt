package com.example.rafaellat.kotlinexercise


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.app.Activity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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
        val addressObserver = Observer<String> { addressValue ->
            // Update the UI, in this case, a TextView.
            Log.d("MESS ADDRESS", addressValue)
            address.setText(addressValue)
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        addressData?.observe(this, addressObserver)

       // FirebaseSingleton.instance.showAddress()
        fab.setOnClickListener {
            // class.java even if it's in kotlin
            val createIntent= Intent (this@MainActivity, CreateAddressActivity::class.java)
            // to receive data from the next activity
            startActivity(createIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}