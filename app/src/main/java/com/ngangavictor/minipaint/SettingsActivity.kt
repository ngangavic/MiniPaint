package com.ngangavictor.minipaint

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.colorpickerview.ColorPickerDialog
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener

class SettingsActivity : AppCompatActivity() {

    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val toolBar: Toolbar = findViewById(R.id.toolbar2)
        toolBar.title = "Settings"
        setSupportActionBar(toolBar)

        if (supportActionBar!=null) {
//        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        imageView = findViewById(R.id.imageView)

//        imageView.setOnClickListener { backgroundColor() }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


}