package io.droidcrew.recycler

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.api.PrefetchRecycledViewPool
import io.droidcrew.recycler.api.PrefetchedViewsCountListener
import io.droidcrew.recycler.framecounter.DroppedFrameCounter
import io.droidcrew.recycler.framecounter.DroppedFramesListener
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var droppedFrameCounter: DroppedFrameCounter
    private lateinit var droppedFramesText: TextView
    private lateinit var clearDroppedFrames: Button

    internal val viewPool = PrefetchRecycledViewPool(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        Timber.plant(Timber.DebugTree())

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

        droppedFramesText = findViewById(R.id.dropped_frames_count)
        clearDroppedFrames = findViewById(R.id.clear_dropped_frames)

        droppedFrameCounter = DroppedFrameCounter(this)
        droppedFrameCounter.framesListener = object : DroppedFramesListener {
            override fun onFramesCounterChanged(count: Int) {
                droppedFramesText.text = "Dropped frames: $count"
            }
        }

        clearDroppedFrames.setOnClickListener {
            droppedFrameCounter.reset()
            droppedFramesText.text = "Dropped frames: 0"
        }

        viewPool.start()
    }


    override fun onDestroy() {
        viewPool.terminate()
        super.onDestroy()
    }

}