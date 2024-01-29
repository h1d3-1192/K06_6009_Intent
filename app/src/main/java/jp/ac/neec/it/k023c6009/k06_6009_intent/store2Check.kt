package jp.ac.neec.it.k023c6009.k06_6009_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView

class store2Check : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store2_check)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //所持金
        val tvMoney = findViewById<TextView>(R.id.tvMoney)
        val money = intent.getStringExtra("money")
        tvMoney.text = "$money　"

        val Money = money?.replace("円","")?.trim()?.toIntOrNull() ?:0


        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val selectedItemName = intent.getStringExtra("menuName")
        val selectedItemPrice = intent.getStringExtra("menuPrice")?.replace("円", "")?.toIntOrNull()

        // メッセージ
        if (selectedItemPrice != null && money != null) {
            if (selectedItemPrice <= Money) {
                val message =
                    "ご購入ありがとうございます。\n商品:$selectedItemName 価格:$selectedItemPrice 円"
                tvMessage.text = message
            } else {
                // 商品の値段が所持金より多い場合のメッセージ
                tvMessage.text = "　\n 所持金が足りません"
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVAl = true

        // 戻るメニュー
        if(item.itemId == android.R.id.home){
            finish()
        }
        else{
            returnVAl = super.onOptionsItemSelected(item)
        }
        return returnVAl
    }

}