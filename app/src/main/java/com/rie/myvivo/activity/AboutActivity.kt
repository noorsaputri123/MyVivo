package com.rie.myvivo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rie.myvivo.R

@Suppress("DEPRECATION")
//Noor Saputri
class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}