package com.example.svetofor_kotlion

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.Timer
import java.util.TimerTask

class MainActivity : Activity() {

    var imSemafor: ImageView? = null
    var counter: Int = 0
    var timer: Timer? = null
    var isRun: Boolean = false
    var imageArray: IntArray =
        intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imSemafor = findViewById(R.id.imSemafor)

    }

    fun onClickStartStop(view: View) {

        view as ImageButton
        if (!isRun) {
            timer = Timer()
            start_stop()
            view.setImageResource(R.drawable.button_stop)
            isRun = true
        } else {
            timer?.cancel()
            view.setImageResource(R.drawable.button_start)
            imSemafor?.setImageResource(R.drawable.semafor_grey)
            isRun = false
            counter = 0
        }
    }

    fun start_stop() {

        timer = Timer()

        timer?.schedule(object : TimerTask() {
            override fun run() {
              runOnUiThread {
                  imSemafor?.setImageResource(imageArray[counter])
                  counter++

                  if (counter == 3) {
                      counter = 0
                  }
              }

            }
        }, 0, 1000 )

    }
}