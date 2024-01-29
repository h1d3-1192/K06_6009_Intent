package jp.ac.neec.it.k023c6009.k06_6009_intent

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MenuListFragment : Fragment(R.layout.fragment_menu_list){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 所持金

        val tvMoneyPossessed = view.findViewById<TextView>(R.id.tvbankname)
        val moneyPossessed = arguments?.getString("moneyPossessed") ?: ""
        tvMoneyPossessed.text = "$moneyPossessed 円"



        // メニューリスト
        val store1Menu = view.findViewById<ListView>(R.id.store1Menu)
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        val names = arrayOf(
            "蒙古タンメン",
            "豚骨ラーメン",
            "醬油ラーメン",
            "月見ラーメン",
            "ヘルシー拉麺",
            "焼き拉麺",
            "餃子拉麺",
            "ぶっかけらーめん",
            "つけめん",
            "にぼしらーめん"
        )
        val prices: MutableList<Int> = mutableListOf(
            800, 1000, 500, 500, 800, 800, 800, 800, 1200, 800
        )

        for (i in names.indices) {
            val menu = mutableMapOf("name" to names[i], "price" to "${prices[i]}円")
            menuList.add(menu)
        }

        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter =
            SimpleAdapter(activity, menuList, android.R.layout.simple_list_item_2, from, to)

        store1Menu.adapter = adapter
        store1Menu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>, view:View, position:Int, id:Long){
            val item = parent.getItemAtPosition(position)as MutableMap<String,String>

            val menuName = item["name"]
            val menuPrice = item["price"]
            val moneyPossessed = arguments?.getString("moneyPossessed") ?: ""

            val bundle = Bundle()

            bundle.putString("menuName",menuName)
            bundle.putString("menuPrice",menuPrice)
            bundle.putString("moneyPossessed",moneyPossessed)

            activity?.let {
                val transaction = parentFragmentManager.beginTransaction()
                transaction.setReorderingAllowed(true)

                val fragmentMainContainer = it.findViewById<View>(R.id.fragmentMainContainer)

                if(fragmentMainContainer != null){
                    transaction.replace(R.id.fragmentMainContainer,MenuThanksFragment::class.java,bundle)
                }
                else{
                    transaction.replace(R.id.fragmentThanksContainer,MenuThanksFragment::class.java,bundle)
                }
                transaction.commit()
            }
        }
    }
}
