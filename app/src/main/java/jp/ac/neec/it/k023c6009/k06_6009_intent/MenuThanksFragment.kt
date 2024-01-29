package jp.ac.neec.it.k023c6009.k06_6009_intent


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class MenuThanksFragment : Fragment(R.layout.fragment_menu_thanks){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 所持金
        val tvMoneyPossessed = view.findViewById<TextView>(R.id.tvbankname)
        val moneyPossessed = arguments?.getString("moneyPossessed")
        tvMoneyPossessed.text = "$moneyPossessed 円"


        // メッセージ
        val tvMessage = view.findViewById<TextView>(R.id.tvMessage)
        val menuName = arguments?.getString("menuName") ?: ""
        val menuPrice = arguments?.getString("menuPrice") ?: ""

        //計算用に整える
        val money = moneyPossessed?.toIntOrNull() ?: 0
        val price = menuPrice?.replace("円", "")?.toIntOrNull() ?: 0


        if (price <= money) {
            val message = "メッセージ\nご購入ありがとうございます。\n商品: \n $menuName\n価格: \n $menuPrice 円"
            tvMessage.text = message
        } else {
            // 商品の値段が所持金より多い場合のメッセージ
            tvMessage.text = "メッセージ\n所持金が足りません"
        }


        // 戻るボタン
        val bt_Back_first = view.findViewById<Button>(R.id.bt_confirmation)
        bt_Back_first.setOnClickListener(ButtonClickListener())
    }

    private inner class ButtonClickListener : View.OnClickListener{
        override fun onClick(v: View?) {

            val moneyPossessed = arguments?.getString("moneyPossessed") ?: ""
            val bundle = Bundle()
            bundle.putString("moneyPossessed",moneyPossessed)

            activity?.let {
                val fragmentMainContainer = it.findViewById<View>(R.id.fragmentMainContainer)
                val transaction = parentFragmentManager.beginTransaction()
                transaction.setReorderingAllowed(true)
                transaction.remove(this@MenuThanksFragment)

                if (fragmentMainContainer != null) {
                    transaction.replace(R.id.fragmentMainContainer,MenuListFragment::class.java,bundle)
                }
                transaction.commit()
            }
        }
    }
}