package com.example.pubtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pub5pilka = arrayOf("pub superBowl - mecze piłkarskie","pub JackRussel - mecze piłkarskie")
        val pub5tenis = arrayOf("pub SuperRakieta - mecze tenisa")
        val pub10pilka = arrayOf("Pub superBowl - mecze piłkarskie", "pub JackRussel - mecze piłkarskie", "pub footballGame - mecze piłkarskie")
        val pub10tenis = arrayOf("pub superRakieta - mecze tenisa","pub biforek - mecze tenisowe")
        val pub10zuzel = arrayOf("pub Racing - zawody żużlowe")
        val pub15pilka = arrayOf("pub superBowl - mecze piłkarskie", "pub JackRussel - mecze piłkarskie", "pub footballGame - mecze piłkarskie")
        val pub15tenis = arrayOf("pub superRakieta - mecze tenisa", "pub biforek - mecze tenisowe")
        val pub15zuzel = arrayOf("pub Racing - zawody żużlowe")
        val pub20pilka = arrayOf("pub superBowl - mecze piłkarskie", "pub JackRussel - mecze piłkarskie", "pub footballGame - mecze piłkarskie", "pub Wilki, mecze piłkarskie", "pub dzikie Koty, mecze piłkarskie")
        val pub20tenis = arrayOf("pub superRakieta - mecze tenisa","pub biforek - mecze tenisowe", "pub czarno na białym - mecze tenisa")
        val pub20zuzel = arrayOf("pub Racing - zawody żużlowe")


        val ilekm = findViewById<SeekBar>(R.id.ileKm)
        val resultList = ArrayList<String>()
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resultList)
        val pubList = findViewById<ListView>(R.id.listaPubow)

        pubList.adapter = arrayAdapter

        ilekm.setOnSeekBarChangeListener(object: OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekbar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekbar: SeekBar?) {

            }
        })

        // BUTTON
        val znajdzpub = findViewById<Button>(R.id.szukajButton)
        znajdzpub.setOnClickListener {
            val pilka = findViewById<CheckBox>(R.id.pilka)
            val tenis = findViewById<CheckBox>(R.id.tenis)
            val zuzel = findViewById<CheckBox>(R.id.zuzel)

            resultList.clear()

            if(ilekm.progress == 0){
                resultList.add("Brak pubow w twojej okolicy")
            } else {
                when(ilekm.progress){
                    5 -> {
                        if(pilka.isChecked){
                            resultList.addAll(pub5pilka)
                        }
                        if(tenis.isChecked){
                            resultList.addAll(pub5tenis)
                        }
                    }
                    10 -> {
                        if (pilka.isChecked){
                            resultList.addAll(pub10pilka)
                        }
                        if(tenis.isChecked){
                            resultList.addAll(pub10tenis)
                        }
                        if(zuzel.isChecked){
                            resultList.addAll(pub10zuzel)
                        }
                    }
                    15 -> {
                        if (pilka.isChecked){
                            resultList.addAll(pub15pilka)
                        }
                        if(tenis.isChecked){
                            resultList.addAll(pub15tenis)
                        }
                        if(zuzel.isChecked){
                            resultList.addAll(pub15zuzel)
                        }
                    }
                    20 -> {
                        if (pilka.isChecked){
                            resultList.addAll(pub20pilka)
                        }
                        if(tenis.isChecked){
                            resultList.addAll(pub20tenis)
                        }
                        if(zuzel.isChecked){
                            resultList.addAll(pub20zuzel)
                        }
                    }
                    else -> {
                        // handle other cases or do nothing
                    }
                }
            }
            arrayAdapter.notifyDataSetChanged()
        }
    }
}