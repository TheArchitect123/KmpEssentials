package com.architect.kmpessentials.filePicker.internals.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.architect.kmpessentials.filePicker.internals.models.BaseConfig
import com.architect.kmpessentials.filePicker.internals.utilities.extentions.isDarkMode
import io.github.thearchitect123.R

internal class PopUpAdapter(
    @LayoutRes private val layoutID: Int,
    private var items: List<BaseConfig>,
    private val itemClicked: (item: BaseConfig, position: Int) -> Unit,
) : RecyclerView.Adapter<PopUpAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutID,
                parent,
                false,
            ),
        ).also {
            it.binding.setOnClickListener { _ ->
                itemClicked(items[it.adapterPosition], it.adapterPosition)
            }
        }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        bind(holder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        val isDarkMode = holder.binding.context.isDarkMode()
        holder.mImageView?.load(item.popUpIcon)
        if (isDarkMode) {
            holder.mImageView?.setColorFilter(
                ContextCompat.getColor(holder.binding.context, R.color.white),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            holder.mTextView?.setTextColor(ContextCompat.getColor(holder.binding.context, R.color.white))
        }

        holder.mTextView?.text = item.popUpText
    }

    class ItemViewHolder(val binding: View) : RecyclerView.ViewHolder(binding) {
        val mImageView: ImageView? = binding.findViewById(R.id.sivLogo)
        val mTextView: TextView? = binding.findViewById(R.id.mtvText)
    }

    override fun getItemCount() = items.size
}
