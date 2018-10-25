package com.example.rafaellat.kotlinexercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AddressAdapter(
    private val addressList: ArrayList<AddressModel>
) : RecyclerView.Adapter<AddressAdapter.AddressHolder>() {

    class AddressHolder(addressView: View) : RecyclerView.ViewHolder(addressView) {
        val addressText = addressView.findViewById(R.id.address_text_view) as TextView
        val cityText = addressView.findViewById(R.id.city_text_view) as TextView

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressAdapter.AddressHolder {
        // create a new view
        val addressView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_address, parent, false) as View

        return AddressHolder(addressView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(addressHolder: AddressHolder, position: Int) {

        val addressModel = getItem(position) as AddressModel
        addressHolder.addressText.text = addressModel.address
        addressHolder.cityText.text = addressModel.city

        addressHolder.itemView.setOnClickListener {
            FirebaseRepository.instance.deleteAddress(addressModel.id)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = addressList.size

    fun getItem(position: Int): Any {
        return addressList[position]
    }

}