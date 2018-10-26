package com.example.rafaellat.kotlinexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

//it will automatically find the id in the layout, I just need to call the variable with the same name
import kotlinx.android.synthetic.main.activity_create_address.*


class CreateAddressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_address)

        confirmButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {

                val address = addressText.text.toString()
                val city = cityText.text.toString()
                FirebaseRepository.instance.addAddress(address, city)
                finish()
            }
        })
    }
}
