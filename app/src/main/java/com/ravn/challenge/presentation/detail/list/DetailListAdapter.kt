package com.ravn.challenge.presentation.detail.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ravn.core.model.starwars.detail.DetailItemModel
import com.ravn.core.model.util.DetailViewType
import com.ravn.challenge.R
import com.ravn.challenge.databinding.ItemDualTextBinding
import com.ravn.challenge.databinding.ItemHeaderBinding
import com.ravn.challenge.databinding.ItemSingleTextBinding

class DetailListAdapter(
    private var itemList: List<DetailItemModel> = mutableListOf(),
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            DetailViewType.HEADER.value -> {
                HeaderViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_header,
                        parent,
                        false
                    )
                )
            }
            DetailViewType.ATRIBUTE.value -> {
                DoubleTextViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_dual_text,
                        parent,
                        false
                    )
                )
            }
            else -> {
                SingleTextViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_single_text,
                        parent,
                        false
                    )
                )
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when {
            holder is HeaderViewHolder -> holder.bindData(itemList[position])
            holder is SingleTextViewHolder -> holder.bindData(itemList[position])
            holder is DoubleTextViewHolder -> holder.bindData(itemList[position])
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int = itemList[position].viewType.value

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemHeaderBinding? = DataBindingUtil.bind(view)
        fun bindData(
            item: DetailItemModel,
        ) {
            binding?.viewModel =
                ItemDetailListViewModel(
                    item
                )
            binding?.viewModel?.bindData()
        }
    }

    class DoubleTextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemDualTextBinding? = DataBindingUtil.bind(view)
        fun bindData(
            item: DetailItemModel,
        ) {
            binding?.viewModel =
                ItemDetailListViewModel(
                    item
                )
            binding?.viewModel?.bindData()
        }
    }

    class SingleTextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemSingleTextBinding? = DataBindingUtil.bind(view)
        fun bindData(
            item: DetailItemModel,
        ) {
            binding?.viewModel =
                ItemDetailListViewModel(
                    item
                )
            binding?.viewModel?.bindData()
        }
    }
}
