package cn.edu.sicnu.cs.lrj.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import java.util.TimerTask

class StopWatchViewModel : ViewModel() {
    private var timer: Timer? = null
    private var startTime: Long = 0L
    private var pausedTime: Long = 0L
    private var isRunning = false

    private val _timeText = MutableLiveData<String>("00:00.00")
    val timeText: LiveData<String> = _timeText

    fun start() {
        if (isRunning) return
        isRunning = true
        startTime = System.currentTimeMillis() - pausedTime
        timer = Timer()
        timer?.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val current = System.currentTimeMillis() - startTime
                val min = (current / 60000) % 60
                val sec = (current / 1000) % 60
                val ms = (current % 1000) / 10
                _timeText.postValue(String.format("%02d:%02d.%02d", min, sec, ms))
            }
        }, 0, 10)
    }

    fun pause() {
        if (!isRunning) return
        isRunning = false
        timer?.cancel()
        timer = null
        pausedTime = System.currentTimeMillis() - startTime
    }

    fun reset() {
        pause()
        pausedTime = 0L
        _timeText.value = "00:00.00"
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}
