package com.rie.myvivo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rie.myvivo.activity.AboutActivity
import com.rie.myvivo.adapter.ListVivoAdapter
import com.rie.myvivo.model.Vivo

//Noor Saputri
class MainActivity : AppCompatActivity() {
    private lateinit var rvVivohp: RecyclerView
    private val list = ArrayList<Vivo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvVivohp = findViewById(R.id.rv_Vivohp)
        rvVivohp.setHasFixedSize(true)

        list.addAll(getListVivohp())
        showRecyclerList()

    }
    private fun getListVivohp(): ArrayList<Vivo> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPenyimpanan = resources.getStringArray(R.array.data_penyimpanan)
        val dataRam = resources.getStringArray(R.array.data_ram)
        val dataHarga = resources.getStringArray(R.array.data_harga)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listVivo = ArrayList<Vivo>()
        for (i in dataName.indices) {
            val vivo = Vivo(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataPenyimpanan[i], dataRam[i], dataHarga[i],)
            listVivo.add(vivo)
        }
        return listVivo
    }

    private fun showRecyclerList() {
        rvVivohp.layoutManager = LinearLayoutManager(this)
        val listVivoAdapter = ListVivoAdapter(list)
        rvVivohp.adapter = listVivoAdapter

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val moveAbout = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(moveAbout)
        return super.onOptionsItemSelected(item)
    }



}