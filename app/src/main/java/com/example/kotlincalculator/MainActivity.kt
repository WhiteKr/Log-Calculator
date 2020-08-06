package com.example.kotlincalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        continueBtn.setOnClickListener {
            try {
                val bf = b.text.toString().toFloat() // 진수
                val xf = x.text.toString().toFloat() // 밑
                val result = log(bf, xf).toString()

                resText.text = result
//                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                val eRes: String

                if (b.text.toString() == "" || x.text.toString() == "") {
                    eRes = "밑과 진수를 모두 입력해주세요."
                } else if (resText == null) {
                    eRes = "결과값이 null 입니다. 바른 값을 입력했는지 다시 확인하세요"
                } else {
                    resText.text = "에러 발생!\n$e"
//                    Toast.makeText(this, "에러 발생!\n$e", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                resText.text = "주의!\n$eRes"
//                Toast.makeText(this, "오류!\n$eRes", Toast.LENGTH_SHORT).show()
            }
        }

        auto2.setOnClickListener {
            x.setText("2")
        }
        auto10.setOnClickListener {
            x.setText("10")
        }
        delAll.setOnClickListener {
            x.setText("")
            b.setText("")
            resText.text = ""
        }
    }
}