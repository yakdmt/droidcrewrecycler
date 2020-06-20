package io.droidcrew.recycler

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<Button>(R.id.button_home).setOnClickListener { view ->
            findNavController(R.id.nav_host_fragment).navigate(R.id.action_to_HomeFragment)
        }

        findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.action_to_FirstFragment)
        }

        findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.action_to_SecondFragment)
        }

        findViewById<Button>(R.id.button_third).setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.action_to_ThirdFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}