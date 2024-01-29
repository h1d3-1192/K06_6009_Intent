package jp.ac.neec.it.k023c6009.k06_6009_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import android.widget.Toast

class Store2 : AppCompatActivity() {
    //listviewに表示するリストデータ
    private var _menuList:MutableList<MutableMap<String,Any>> = mutableListOf()
    //simpleAdapterの第四引数 from　に使用するプロパティ
    private val _from = arrayOf("name","price")

    private  val _to = intArrayOf(R.id.lvMenu2,R.id.tvMoney)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // 所持金表示
        val tvMoney = findViewById<TextView>(R.id.tvMoney)
        val money = intent.getStringExtra("etMoney")
        tvMoney.text = "$money　円"

        _menuList = createFoodList()

        val menuList: MutableList<MutableMap<String, Any>> = _menuList

        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter =
            SimpleAdapter(
                this@Store2,
                menuList,
                android.R.layout.simple_list_item_2,
                from,
                to
            )

        val lvMenu2 = findViewById<ListView>(R.id.lvMenu2)
        lvMenu2.adapter = adapter

        // コンテキストメニュー
        registerForContextMenu(lvMenu2)

        lvMenu2.onItemClickListener = ListItemClickListener()

    }
    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            //タップされた行のデータを取得。simpleadapterでは1行分のデータはmutablemap型
            val item = parent.getItemAtPosition(position) as MutableMap<String,Any>
            order(item)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean { //?はnullを強要するもの
        //オプションメニュー用cmlファイルを員プレート
        menuInflater.inflate(R.menu.menu_option_menu_list,menu)
        return true
    }

//    private fun order(menu: MutableMap<String,String>){
//        val menuName = menu["name"] as String
//        val menuPrice = menu["price"] as String
//        val tvMoney = findViewById<TextView>(R.id.tvMoney).text.toString()
//
//        val intent2MenuThanks = Intent(this@Store2,store2Check::class.java)
//        intent2MenuThanks.putExtra("menuName",menuName)
//        intent2MenuThanks.putExtra("menuPrice","${menuPrice}")
//        intent2MenuThanks.putExtra("money", tvMoney)
//        startActivity(intent2MenuThanks)
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVAl = true

        // 戻るメニュー
        if(item.itemId == android.R.id.home){
            finish()
        }
        else{
            returnVAl = super.onOptionsItemSelected(item)
        }

        when (item.itemId) {
            R.id.menuListOptionDrink ->
                _menuList = createDrinkList()

            R.id.menuListOptionFood ->
                _menuList = createFoodList()

            R.id.menuListOptionOtumami ->
                _menuList = createOtumamiList()

            else ->
                returnVAl = super.onOptionsItemSelected(item)
        }

        val lvMenu = findViewById<ListView>(R.id.lvMenu2)
        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter = SimpleAdapter(
            this@Store2,
            _menuList,
            android.R.layout.simple_list_item_2,
            from,
            to
        )
        lvMenu.adapter = adapter


        return returnVAl
    }


    private fun createFoodList():MutableList<MutableMap<String,Any>> {
        //定食メニューリスト用

        val menuList: MutableList<MutableMap<String,Any>> = mutableListOf()
        val names = arrayOf(
            "唐揚げ定食","ハンバーグ定食","生姜焼き定食","ステーキ定食","野菜炒め定食",
            "とんかつ定食","メンチカツ定食","チキンカツ定食","コロッケ定食","回鍋肉定食",
            "麻婆豆腐定食","夏野菜炒め定食","らーめん定食"
        )
        val prices : MutableList<Int> = mutableListOf(
            800,850,1000,750,900,
            850,600,700,800,850,
            700,730,600
        )
        val desc = arrayOf(
            "焼き鳥のから揚げにサラダ、ご飯とお味噌汁がつきます",
            "ハンバーグ定食には、ご飯とお味噌汁がつきます",
            "生姜焼き定食には、ご飯とお味噌汁がつきます",
            "ステーキ定食には、ご飯とお味噌汁がつきます",
            "野菜炒め定食には、ご飯とお味噌汁がつきます",
            "とんかつ定食には、ご飯とお味噌汁がつきます",
            "メンチカツ定食には、ご飯とお味噌汁がつきます",
            "チキンカツ定食には、ご飯とお味噌汁がつきます",
            "コロッケ定食には、ご飯とお味噌汁がつきます",
            "回鍋肉定食には、ご飯とお味噌汁がつきます",
            "麻婆豆腐定食には、ご飯とお味噌汁がつきます",
            "野菜炒め定食には、ご飯とお味噌汁がつきます",
            "らーめん定食には、ご飯とお味噌汁がつきます",


            )


        for(i in names.indices){
            val menu = mutableMapOf<String,Any>("name" to names[i],"price" to prices[i],"desc" to desc[i])
            menuList.add(menu)
        }
        return menuList
    }
    private fun createDrinkList():MutableList<MutableMap<String,Any>> {
        //定食メニューリスト用

        val menuList: MutableList<MutableMap<String,Any>> = mutableListOf()
        val names = arrayOf(
            "ビーフカレー","キーマカレー","チキンカレー","ステーキカレー","夏野菜カレー",
            "カツカレー","ハンバーグカレー"
        )
        val prices : MutableList<Int> = mutableListOf(
            800,850,800,750,900,
            850,600
        )
        val desc = arrayOf(
            "国産牛肉を使用した特性ビーフカレーです",
            "国産豆と使用したキーマカレーです",
            "スパイスを聞かせたチキンカレーです",
            "やわらかい神戸牛ののステーキカレーです",
            "栄養素満点、夏野菜カレー！",
            "元気ガツガツのカツカレー",
            "みんな大好きハンバーグカレー",
        )


        for(i in names.indices){
            val menu = mutableMapOf<String,Any>("name" to names[i],"price" to prices[i],"desc" to desc[i])
            menuList.add(menu)
        }
        return menuList
    }
    private fun createOtumamiList():MutableList<MutableMap<String,Any>> {
        //定食メニューリスト用

        val menuList: MutableList<MutableMap<String,Any>> = mutableListOf()
        val names = arrayOf(
            "唐揚げ","枝豆","フライドポテト","焼き鳥三種","春巻き",
            "そらめめ","ユッケ","メンマ","コロッケ","焼き鳥丼",
            "〆のおかゆ","日替わりつまみ","〆の拉麺"
        )
        val prices : MutableList<Int> = mutableListOf(
            800,850,1000,750,900,
            850,600,700,800,850,
            700,730,600
        )
        val  desc = arrayOf(
            "国産牛肉を使用した特性ビーフカレーです",
            "国産豆と使用したキーマカレーです",
            "スパイスを聞かせたチキンカレーです",
            "やわらかい神戸牛ののステーキカレーです",
            "栄養素満点、夏野菜カレー！",
            "元気ガツガツのカツカレー",
            "みんな大好きハンバーグカレー",
            "みんな大好きハンバーグカレー",
            "みんな大好きハンバーグカレー",
            "みんな大好きハンバーグカレー",
            "みんな大好きハンバーグカレー",
            "みんな大好きハンバーグカレー",
            "みんな大好きハンバーグカレー",
        )


        for(i in names.indices){
            val menu = mutableMapOf<String,Any>("name" to names[i],"price" to prices[i],"desc" to desc[i])
            menuList.add(menu)
        }
        return menuList
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.menu_context_menu_list,menu)
        menu.setHeaderTitle(R.string.menu_list_context_header)
    }
    private fun order(menu: MutableMap<String,Any>){
        val menuName  = menu["name"] as String
        val menuPrice = menu["price"] as Int
        val money = findViewById<TextView>(R.id.tvMoney).text.toString()
        val intent2MenuThanks = Intent(this@Store2,
            store2Check::class.java)

        intent2MenuThanks.putExtra("menuName",menuName)
        intent2MenuThanks.putExtra("menuPrice","${menuPrice}円")
        intent2MenuThanks.putExtra("money",money)
        startActivity(intent2MenuThanks)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var returnVal = true

        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo

        //長押しされたリストのポジションを取得
        val listPosition = info.position

        //ポジションから長押しされたメニュー情報を取得
        val menu = _menuList[listPosition]


        when(item.itemId){
            R.id.menuListContextDesc -> {
                val desc = menu["desc"] as String

                //トーストを表示
                Toast.makeText(this@Store2,desc, Toast.LENGTH_LONG).show()
            }

            //[ご注文]メニューが選択された時の処理
            R.id.menuListContextOrder ->
                //注文処理
                order(menu)

            else ->
                //親クラスの同名メソッドを呼び出し、その戻り値をreturnValとする
                returnVal = super.onContextItemSelected(item)

        }
        return returnVal

    }

    fun onBackButtonClick(view: View) {
        finish()
    }

}

