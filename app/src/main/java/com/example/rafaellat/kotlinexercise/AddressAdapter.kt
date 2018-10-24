package com.example.rafaellat.kotlinexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

//import kotlinx.android.synthetic.list_item_address.*

class AddressAdapter(private val context: Context,
                     private val dataSource: ArrayList<AddressModel>): BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_address, parent, false)
        val addressModel= getItem(position) as AddressModel
        val addressValue = rowView.findViewById(R.id.address_value) as TextView
        val cityValue = rowView.findViewById(R.id.city_value) as TextView

        addressValue.text = addressModel.address
        cityValue.text = addressModel.city
        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
       return dataSource.size
    }

}