package cn.edu.sicnu.cs.lrj.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class StopWatchActivity : AppCompatActivity() {

    private lateinit var viewModel: StopWatchViewModel
    private lateinit var tvTime: TextView
    private lateinit var btnStartPause: Button
    private lateinit var btnReset: Button
    private var isRunningState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)

        viewModel = ViewModelProvider(this)[StopWatchViewModel::class.java]
        tvTime = findViewById(R.id.tvTime)
        btnStartPause = findViewById(R.id.btnStartPause)
        btnReset = findViewById(R.id.btnReset)
        val btnBackMain: Button = findViewById(R.id.btnBackMain)

        viewModel.timeText.observe(this) {
            tvTime.text = it
        }

        btnStartPause.setOnClickListener {
            if (!isRunningState) {
                viewModel.start()
                btnStartPause.text = "暂停"
                isRunningState = true
            } else {
                viewModel.pause()
                btnStartPause.text = "开始"
                isRunningState = false
            }
        }

        btnReset.setOnClickListener {
            viewModel.reset()
            btnStartPause.text = "开始"
            isRunningState = false
        }

        btnBackMain.setOnClickListener {
            finish()
        }
    }
}
