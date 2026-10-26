package cn.edu.sicnu.cs.lrj.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etSendData: EditText
    private lateinit var tvResultBack: TextView

    //接收Third回传数据
    private val thirdLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val backText = result.data?.getStringExtra("backData")
            tvResultBack.text = "Third返回结果：$backText"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSendData = findViewById(R.id.etSendData)
        tvResultBack = findViewById(R.id.tvResultBack)

        val btnToSecond: Button = findViewById(R.id.btnToSecond)
        val btnToThird: Button = findViewById(R.id.btnToThird)
        val btnToForth: Button = findViewById(R.id.btnToForth)
        val btnToStopWatch: Button = findViewById(R.id.btnToStopWatch)

        //按钮1：跳转Second，正向传参
        btnToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("sendKey", etSendData.text.toString())
            startActivity(intent)
        }

        //按钮2：跳转Third，接收返回数据
        btnToThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            thirdLauncher.launch(intent)
        }

        //按钮3：跳转Forth拍照页面
        btnToForth.setOnClickListener {
            val intent = Intent(this, ForthActivity::class.java)
            startActivity(intent)
        }

        //按钮4：跳转StopWatch预留秒表页面，暂不实现计时功能
        // 按钮4 打开秒表
        btnToStopWatch.setOnClickListener {
            val intent = Intent(this, StopWatchActivity::class.java)
            startActivity(intent)
        }

    }
}
