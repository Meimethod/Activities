package cn.edu.sicnu.cs.lrj.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvReceive: TextView = findViewById(R.id.tvReceive)
        val btnBackMain: Button = findViewById(R.id.btnBackMain)

        val receiveStr = intent.getStringExtra("sendKey")
        tvReceive.text = "SecondActivity收到：$receiveStr"

        btnBackMain.setOnClickListener {
            finish()
        }
    }
}
