package jp.ac.neec.it.k023c6009.k06_6009_intent


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etName = findViewById<EditText>(R.id.etName)
        val etMoney = findViewById<EditText>(R.id.etMoney)
        val buttonStore1: Button = findViewById(R.id.btStore1)
        val buttonStore2: Button = findViewById(R.id.btStore2)
        val buttonBank: Button = findViewById(R.id.btBank)
        val moneyPossessed = findViewById<EditText>(R.id.etMoney)


        //店１
        buttonStore1.setOnClickListener(View.OnClickListener {
            val moneyPossessed = findViewById<EditText>(R.id.etMoney)
          
            //store1activityに遷移するintentを作成
            val intent_store1 = Intent(this@MainActivity,Store1::class.java)

            intent_store1.putExtra("moneyPossessed",moneyPossessed)
            startActivity(intent_store1)
        })

        buttonStore2.setOnClickListener(View.OnClickListener {
            //store1activityに遷移するintentを作成
            val money = etMoney.text.toString()
            val intent = Intent(this@MainActivity,Store2::class.java)
            intent.putExtra("etMoney",etMoney)
            startActivity(intent)
        })

        buttonBank.setOnClickListener(View.OnClickListener {
            val name = etName.text.toString()
            val money = etMoney.text.toString()
            //store1activityに遷移するintentを作成
            val intent = Intent(this@MainActivity,mainBank::class.java)
            intent.putExtra("etMoney",money)
            intent.putExtra("etName",name)
            startActivity(intent)
        })

    }
}

private fun Intent.putExtra(s: String, moneyPossessed: EditText?) {

}


