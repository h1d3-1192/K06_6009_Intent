package jp.ac.neec.it.k023c6009.k06_6009_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView

class Store1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store1)

        //戻る
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // 所持金
        val moneyPossessed = intent.getStringExtra("moneyPossessed")
        val fragment = MenuListFragment()
        val bundle = Bundle()
        bundle.putString("moneyPossessed",moneyPossessed)
        fragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)

        val fragmentMainContainer = findViewById<View>(R.id.fragmentMainContainer)

        if(fragmentMainContainer != null){
            transaction.replace(R.id.fragmentMainContainer,fragment)
        }
        else{
            transaction.replace(R.id.fragmentListContainer,fragment)
        }
        transaction.commit()





























//        // store1.xml の TextView に表示
//        val tvMoney: TextView = this.findViewById(R.id.tvMoney)
//        val intent = intent
//        val money = intent.getStringExtra("etMoney")
//        tvMoney.text = "$money"
//
//
//
//
//        //val Store1Menu = findViewById<ListView>(R.id.Store1Menu)
//        val menuList:MutableList<MutableMap<String,String>> = mutableListOf()
//        var names = arrayOf(
//            "ラ王","ペヤング","一平ちゃん","タンタンメンカップ","スーパーカップ",
//            "ジャンボ拉麺","ガツ盛りラーメン","天ぷらそばカップ","醬油カップラーメン","肉うどん",
//            "中華拉麺","タンメン","アメリカ拉麺"
//        )
//        var prices : MutableList<Int> = mutableListOf(
//            800,850,1000,750,900,
//            850,600,700,800,850,
//            700,730,600
//        )
//
//        for(i in names.indices){
//            var menu = mutableMapOf("name" to names[i],"price" to prices[i].toString() + "円")
//            menuList.add(menu)
//        }
//
//        val from = arrayOf("name","price")
//        val to = intArrayOf(android.R.id.text1,android.R.id.text2)
//        val adapter = SimpleAdapter(this@Store1,menuList, android.R.layout.simple_list_item_2, from,to)
//        val lvMenu1 = findViewById<ListView>(R.id.lvMenu1)
//        lvMenu1.adapter = adapter
//
//        lvMenu1.setOnItemClickListener{ _, _, position, _ ->
//            //定食名と金額を取得
//            val selectedItem = menuList[position]
//
//            val intent2MenuThanks = Intent(this@Store1, store1Check::class.java)
//            //第二画面に送るデータを格納
//            intent2MenuThanks.putExtra("money",money)
//            intent2MenuThanks.putExtra("menuName",selectedItem["name"])
//            intent2MenuThanks.putExtra("menuPrice",selectedItem["price"])
//            //第二画面を起動
//            startActivity(intent2MenuThanks)
//
//        }
    }

}