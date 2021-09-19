package com.ngangavictor.minipaint

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolBar: Toolbar = findViewById(R.id.toolbar)
        toolBar.title = "Mini Paint"
        setSupportActionBar(toolBar)


        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        val myCanvasView = MyCanvasView(this)
        linearLayout.addView(myCanvasView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {

            }
            R.id.action_settings -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }
}