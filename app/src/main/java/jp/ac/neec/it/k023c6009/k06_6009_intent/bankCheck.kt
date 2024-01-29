package jp.ac.neec.it.k023c6009.k06_6009_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class bankCheck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_check)

        val buttonReturn: Button = findViewById(R.id.btReturn)
        val tvName: TextView  = this.findViewById(R.id.tvName)
        val name = intent.getStringExtra("etName")
        val message2 = "$name"
        tvName.text = message2
        //所持金
        val shoji = intent.getStringExtra("tvShoji")
        val hikidashi = intent.getStringExtra("etHikidashi")
        val tvMoney: TextView = this.findViewById(R.id.tvMoney)
        val moneyInt = shoji?.toIntOrNull() ?:0
        val hikidashiInt = hikidashi?.toIntOrNull()?:0
        val result = moneyInt- hikidashiInt

        tvMoney.text = "${result.toString()}"
        //メッセージ

        //tvMoney.text = "$money"

        //val hikidashi = intent.getStringExtra("hikidashi")
        val tvHikidashi: TextView = this.findViewById(R.id.tvHikidashi)
        //val intent = intent
        tvHikidashi.text = "$hikidashi 円引き出しました"







        buttonReturn.setOnClickListener(View.OnClickListener {
            //Mainactivityに遷移するintentを作成
            val intent = Intent(this@bankCheck,MainActivity::class.java)
            startActivity(intent)
        })
    }
}