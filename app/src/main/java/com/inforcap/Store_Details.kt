package com.inforcap

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.inforcap.data.Data
import com.inforcap.databinding.ActivityStoreDetailsBinding

class StoreDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoreDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoreDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras?.getBundle("BUNDLE")
        val store = bundle?.getParcelable<Data>("STORE")

        if (store != null) {
            Log.i("INFORMACION", store.name)
        }

        binding.run {
            store?.run {
                nombreTienda.text= name
                direccionTienda.text = address

                direccionTienda.setOnClickListener {
                    val geoIntentUri = Uri.parse("geo:0,0?q=$address")
                    val mapIntent = Intent(Intent.ACTION_VIEW, geoIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    startActivity(mapIntent)
                }

                horario.text = officeHours
                historia.text = history

                Glide.with(applicationContext)
                    .load(photo)
                    .centerCrop()
                    .error(R.drawable.baseline_error_outline_24)
                    .into(imageViewStore)
            }
        }
    }

}