package jp.ac.neec.it.k023c6009.k06_6009_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class mainBank : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_bank)

        //所持金と名前
        val tvMoney: TextView = this.findViewById(R.id.tvMoney)
        val tvName: TextView = this.findViewById(R.id.tvName)
        val money = intent.getStringExtra("etMoney")
        val name = intent.getStringExtra("etName")
        val intent = intent
        val message1 = "$money"
        val message2 = "$name"
        tvMoney.text = message1
        tvName.text = message2

        //引き出し
        val etHikidashi = findViewById<EditText>(R.id.etHikidashi)


        val buttonReturn: Button = findViewById(R.id.btReturn)

        buttonReturn.setOnClickListener(View.OnClickListener {
            val hikidashi = etHikidashi.text.toString()
            val name = tvName.text.toString()
            val shoji = tvMoney.text.toString()
            //BankCheckに遷移するintentを作成
            val intent = Intent(this@mainBank,bankCheck::class.java)
            intent.putExtra("etHikidashi",hikidashi)
            intent.putExtra("etName",name)
            intent.putExtra("tvShoji",shoji)
            startActivity(intent)
        })
    }
}