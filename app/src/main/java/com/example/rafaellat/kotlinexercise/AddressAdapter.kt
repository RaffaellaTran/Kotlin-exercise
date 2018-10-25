package com.example.rafaellat.kotlinexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AddressAdapter(
    private val context: Context,
    private val addressList: ArrayList<AddressModel>
) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val addressModel = getItem(position) as AddressModel
        val rowView = inflater.inflate(R.layout.list_item_address, parent, false)
        val addressViewHolder = AddressViewHolder(
            rowView.findViewById(R.id.address_text_view),
            rowView.findViewById(R.id.city_text_view)
        )
        // inflate the layout
        addressViewHolder.addressTextView.text = addressModel.address
        addressViewHolder.cityTextView.text = addressModel.city
        convertView?.tag = addressViewHolder

        return rowView
    }

    override fun getItem(position: Int): Any {
        return addressList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return addressList.size
    }

    data class AddressViewHolder @JvmOverloads constructor(
        val addressTextView: TextView,
        val cityTextView: TextView

    )

}