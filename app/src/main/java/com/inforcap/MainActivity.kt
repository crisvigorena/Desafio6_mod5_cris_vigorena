package com.inforcap

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.inforcap.adapter.Adapter
import com.inforcap.data.Data
import com.inforcap.databinding.ActivityMainBinding
import com.inforcap.infotiendas.InfoTiendas


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView(InfoTiendas.listadoTiendas)
    }

    private fun initRecyclerView(list: List<Data>){
        adapter = Adapter(list) { onItemSelected(it) }
        binding.recycleView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.recycleView1.adapter = adapter
    }

    private fun onItemSelected(store: Data){
        startActivity(Intent(applicationContext, StoreDetailActivity::class.java).apply {
            putExtra("BUNDLE", Bundle().apply {
                putParcelable("STORE",store)
                putInt("ID",store.id)
            })
        })
    }
}