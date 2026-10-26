package cn.edu.sicnu.cs.lrj.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val etReturnInput: EditText = findViewById(R.id.etReturnInput)
        val btnSendBack: Button = findViewById(R.id.btnSendBack)

        btnSendBack.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("backData", etReturnInput.text.toString())
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }
}
