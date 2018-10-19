package com.example.rafaellat.kotlinexercise

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
//it will automatically find the id in the layout, I just need to call the variable with the same name
import kotlinx.android.synthetic.main.activity_create_address.*


class CreateAddressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_address)

        confirmButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {

                var address = addressText.text.toString()
                var city = cityText.text.toString()
                var text = "Add new address: $address , $city "

                val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_LONG)
                //toast.show()

                val sendDataIntent= Intent (this@CreateAddressActivity, MainActivity::class.java )
                sendDataIntent.putExtra("address", address)
                sendDataIntent.putExtra("city", city)
                setResult(Activity.RESULT_OK,sendDataIntent)
                finish()
            }
        })
    }
}
