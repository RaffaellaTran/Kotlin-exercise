package com.example.rafaellat.kotlinexercise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var addressViewModel: AddressViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        addressViewModel = ViewModelProviders.of(this).get(AddressViewModel::class.java)
        val addressData = addressViewModel.loadAddress()
        val addressObserver = Observer<ArrayList<AddressModel>> { addressValue ->

            // Update the UI
            viewManager = LinearLayoutManager(this)
            viewAdapter = AddressAdapter(addressValue)
            address_recycle_view.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        addressData.observe(this, addressObserver)

        //Create a new address
        fab.setOnClickListener {
            val createIntent = Intent(this@MainActivity, CreateAddressActivity::class.java)
            startActivity(createIntent)
        }
    }
}