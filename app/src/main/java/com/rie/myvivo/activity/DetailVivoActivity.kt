package com.rie.myvivo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.rie.myvivo.R
import com.rie.myvivo.model.Vivo

//Noor Saputri
@Suppress("DEPRECATION")
class DetailVivoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_vivo)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataVivo = intent.getParcelableExtra<Vivo>("key_vivo") as Vivo


        val tvDetailName : TextView = findViewById(R.id.tv_item_name)
        val tvDetailDescription  : TextView  = findViewById(R.id.tv_item_description)
        val ivDetailPhoto : ImageView  = findViewById(R.id.img_item_photo)
        val tvPenyimpanan : TextView = findViewById(R.id.tv_item_penyimpanan)
        val tvRAM : TextView = findViewById(R.id.tv_item_ram)
        val tvHarga : TextView = findViewById(R.id.tv_item_harga)

        tvDetailName.text = dataVivo.name
        tvDetailDescription.text = dataVivo.description
        ivDetailPhoto.setImageResource(dataVivo.photo)
        tvPenyimpanan.text = dataVivo.penyimpanan
        tvRAM.text = dataVivo.ram
        tvHarga.text = dataVivo.harga
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}