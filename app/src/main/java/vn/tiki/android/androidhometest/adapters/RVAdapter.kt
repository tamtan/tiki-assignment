package vn.tiki.android.androidhometest.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_deal.view.*
import vn.tiki.android.androidhometest.MainActivity
import vn.tiki.android.androidhometest.R
import vn.tiki.android.androidhometest.data.api.response.Deal
import java.util.*


class RVAdapter(var mActivity: MainActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas: List<Deal>

    init {
        datas = ArrayList()
    }

    fun setDataList(datas: List<Deal>) {
        this.datas = datas
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_deal, parent, false)
        return DealHolder(v)
    }

    override fun onBindViewHolder(holderin: RecyclerView.ViewHolder, position: Int) {
        if (holderin is DealHolder) {

            Glide.with(mActivity)
                    .load("https://images.pexels.com/photos/658687/pexels-photo-658687.jpeg?auto=compress&cs=tinysrgb&h=350")
                    .into(holderin.iv_thumb)
//            GlideApp.with(mActivity)
//                    .load(datas.get(position).productThumbnail)
//                    .into(holderin.iv_thumb)

            holderin.tv_product_name.text = datas.get(position).productName;
            holderin.tv_price.text = datas.get(position).productPrice.toString();
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun getItemCount(): Int {
        return datas.size
    }


    class DealHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv_thumb = itemView.iv_thumb;
        val tv_timer = itemView.tv_timer;
        val tv_product_name = itemView.tv_product_name;
        val tv_price = itemView.tv_price;
    }
}
