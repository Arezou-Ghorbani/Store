package com.example.store.ui.home.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.data.models.home.ResponseDiscount
import com.example.store.databinding.ItemDiscountBinding
import com.example.store.utils.BASE_URL_IMAGE
import com.example.store.utils.base.BaseDiffUtils
import com.example.store.utils.extensions.loadImage
import com.example.store.utils.extensions.moneySeparating
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**Created by Arezou-Ghorbani on 05,November,2023,ArezouGhorbaniii@gmail**/
class DiscountAdapter @Inject constructor(@ApplicationContext private val context: Context) :
    RecyclerView.Adapter<DiscountAdapter.ViewHolder>() {

    private var items = emptyList<ResponseDiscount.ResponseDiscountItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountAdapter.ViewHolder {
        val binding = ItemDiscountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiscountAdapter.ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = position

    override fun getItemId(position: Int) = position.toLong()

    inner class ViewHolder(private val binding: ItemDiscountBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResponseDiscount.ResponseDiscountItem) {
            binding.apply {
                itemTitle.text = item.title
                //Image
                val imageUrl = "$BASE_URL_IMAGE${item.image}"
                itemImg.loadImage(imageUrl)
                //Quantity
                itemProgress.progress = item.quantity.toString().toInt()
                //Final price
                itemPriceDiscount.text = item.finalPrice.toString().toInt().moneySeparating()
                //Discount
                itemPrice.apply {
                    text = item.discountedPrice.toString().toInt().moneySeparating()
                    paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    setTextColor(ContextCompat.getColor(context, R.color.salmon))
                }
                //Click
                root.setOnClickListener {
                    onItemClickListener?.let {
                        it(item.id!!)
                    }
                }
            }
        }
    }

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

    fun setData(data: List<ResponseDiscount.ResponseDiscountItem>) {
        val adapterDiffUtils = BaseDiffUtils(items, data)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = data
        diffUtils.dispatchUpdatesTo(this)
    }
}