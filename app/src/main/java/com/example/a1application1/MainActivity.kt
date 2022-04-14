package com.example.a1application1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val menuu = arrayOf("Plumbers", "Restaurants", "Delivery", "Medicine", )
        var flag: String = "Plumbers"
        val spinner = findViewById<Spinner>(R.id.spinnerr)

        val button: Button = findViewById(R.id.button)
        val arrayAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuu)
        spinner.adapter = arrayAdapter
        button.setOnClickListener{
            var dialogg = Dialog1()
            var dialogg2 = Dialog2()
            var dialogg3 = Dialog3()
            var dialogg4 = Dialog4()
           // var dialogg1 = CustomDialogFragment2()
            if(flag =="Plumbers")
                dialogg.show(supportFragmentManager, "Custom Dialog")
            else if(flag =="Restaurants")
                dialogg2.show(supportFragmentManager, "Custom Dialog")

            else if(flag =="Delivery")
                dialogg3.show(supportFragmentManager, "Custom Dialog")

            else
                dialogg4.show(supportFragmentManager, "Custom Dialog")

        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = menuu.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

    }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            val inflater = menuInflater
            inflater.inflate(R.menu.my_menu, menu)
            return super.onCreateOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.about -> Toast.makeText(this, "About Selected", Toast.LENGTH_SHORT).show()
                R.id.settings -> Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT)
                    .show()
                R.id.exit -> Toast.makeText(this, "Exit Selected", Toast.LENGTH_SHORT).show()
            }
            return super.onOptionsItemSelected(item)
        }

    }
