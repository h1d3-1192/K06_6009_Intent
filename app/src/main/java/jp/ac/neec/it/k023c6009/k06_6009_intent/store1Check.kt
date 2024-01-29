package jp.ac.neec.it.k023c6009.k06_6009_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class store1Check : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store1_check)

        //store1リスト画面から渡されたデータを取得。
        val menuName = intent.getStringExtra("menuName")
        val menuPrice = intent.getStringExtra("menuPrice")?.replace("円","")?.toIntOrNull()
        val money = intent.getStringExtra("money")
        //Mainから受け取った所持金を表示
        val tvMoney: TextView = this.findViewById(R.id.tvMoney)
        val intent = intent
        tvMoney.text = "$money"

        val tvMenuName = findViewById<TextView>(R.id.tvMenuName)
        val tvMenuPrice = findViewById<TextView>(R.id.tvMenuPrice)

        val tvMessage = findViewById<TextView>(R.id.tvNomoney)


        // メッセージ
        if (menuPrice != null && menuPrice <= money?.toIntOrNull() ?:0) {
            //textviewに定食名と金額を表示
            tvMenuName.text = "$menuName"
            tvMenuPrice.text = "$menuPrice"

        }else{
            val message = "所持金が不足しています"
            tvMessage.text = "$message"
        }

        val buttonReturn: Button = findViewById(R.id.btReturnList)

        buttonReturn.setOnClickListener(View.OnClickListener {
            //Mainactivityに遷移するintentを作成
            val intent = Intent(this@store1Check,MainActivity::class.java)
            startActivity(intent)
        })

    }

}