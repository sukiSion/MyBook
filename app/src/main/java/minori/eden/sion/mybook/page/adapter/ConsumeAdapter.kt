package minori.eden.sion.mybook.page.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.qualifiers.ApplicationContext
import minori.eden.sion.mybook.bean.ConsumeItemBean
import minori.eden.sion.mybook.databinding.ItemConsumeBinding
import javax.inject.Inject

/**
 * @author Sion
 * @date 2023/9/8 15:40
 * @description
 * @version 1.0.0
 **/
class ConsumeAdapter @Inject constructor(
    private val consumeItems:List<ConsumeItemBean>,
    @ApplicationContext private val context: Context
): RecyclerView.Adapter<ConsumeAdapter.ConsumeViewHolder>() {

    inner class ConsumeViewHolder(private val binding: ItemConsumeBinding): RecyclerView.ViewHolder(binding.root){
        val tvItemConsume = binding.tvItemConsume
        val ivItemConsume = binding.ivItemConsume
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsumeViewHolder {
        val binding = ItemConsumeBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ConsumeViewHolder(binding)
    }

    override fun getItemCount(): Int = consumeItems.count()

    override fun onBindViewHolder(holder: ConsumeViewHolder, position: Int) {
        holder.also {
            val consumeItemBean = consumeItems[holder.adapterPosition]
            it.ivItemConsume.setImageResource(consumeItemBean.consumeItemIcon)
            it.tvItemConsume.text = context.getString(consumeItemBean.consumeItemName)
        }
    }
}