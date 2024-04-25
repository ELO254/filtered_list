package com.example.filterlist

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var toolbar:Toolbar
    lateinit var recycler:RecyclerView
    lateinit var adapter: itemAdapter

    var l = listOf(Items(R.drawable.cargogreen,"cargo green","$50","clothes"),
        Items(R.drawable.cargocasual,"cargo casual","$40","clothes"),
        Items(R.drawable.nikecanvas,"nike canvas","$100","shoes"),
        Items(R.drawable.nikefirstflight,"nike flight","$120","shoes"),
        Items(R.drawable.nikerunners,"nike runners","$200","shoes"),
        Items(R.drawable.sweatpant,"sweatpant","$30","clothes"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recycler = findViewById(R.id.recy)

        adapter = itemAdapter(l)
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, 2)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.shoes ->{
                var filterlist = ArrayList<Items>()
                for(i in l){
                    if(i.category.lowercase(Locale.ROOT).contains("shoes")){
                        filterlist.add(i)
                    }

                }
                adapter.setFilteredList(filterlist)
            }
            R.id.clothes -> {
                var filterlist = ArrayList<Items>()
                for(i in l){
                    if(i.category.lowercase(Locale.ROOT).contains("clothes")){
                        filterlist.add(i)
                    }

                }
                adapter.setFilteredList(filterlist)
            }
            R.id.home ->{
                adapter = itemAdapter(l)
                recycler.adapter = adapter
                recycler.layoutManager = GridLayoutManager(this,2)

            }
        }
        return super.onOptionsItemSelected(item)
    }
}