package com.ngangavictor.minipaint

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.skydoves.colorpickerview.ColorEnvelope
import com.skydoves.colorpickerview.ColorPickerDialog
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener

class SettingsActivity : AppCompatActivity() {

    lateinit var sharedPrefs: SharedPrefs

    lateinit var imageView: ImageView
    lateinit var imageView2: ImageView

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
        imageView2 = findViewById(R.id.imageView2)

        imageView.setOnClickListener { backgroundColor() }

        imageView2.setOnClickListener { penColor() }



        sharedPrefs= SharedPrefs(this)

    }

    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
        return true
    }

    private fun backgroundColor() {
        ColorPickerDialog.Builder(this)
            .setTitle("Pick Background Color")
            .setPreferenceName("BackgroundColorPickerDialog")
            .setPositiveButton("OK",
                object : ColorEnvelopeListener {
                    override fun onColorSelected(envelope: ColorEnvelope?, fromUser: Boolean) {
                        sharedPrefs.saveColor("background","#"+envelope!!.hexCode)
                        Toast.makeText(this@SettingsActivity,"Background color set",Toast.LENGTH_LONG).show()
                    }
                })
            .setNegativeButton(
                "Cancel"
            ) { dialog, which -> dialog.dismiss() }
            .attachAlphaSlideBar(true) // the default value is true.
            .attachBrightnessSlideBar(true)  // the default value is true.
            .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
            .show()
    }

    private fun penColor() {
        ColorPickerDialog.Builder(this)
            .setTitle("Pick Pen Color")
            .setPreferenceName("PenColorPickerDialog")
            .setPositiveButton("OK",
                object : ColorEnvelopeListener {
                    override fun onColorSelected(envelope: ColorEnvelope?, fromUser: Boolean) {
                        sharedPrefs.saveColor("pen","#"+envelope!!.hexCode)
                        Toast.makeText(this@SettingsActivity,"Pen color set",Toast.LENGTH_LONG).show()
                    }
                })
            .setNegativeButton(
                "Cancel"
            ) { dialog, which -> dialog.dismiss() }
            .attachAlphaSlideBar(true) // the default value is true.
            .attachBrightnessSlideBar(true)  // the default value is true.
            .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
            .show()
    }


}