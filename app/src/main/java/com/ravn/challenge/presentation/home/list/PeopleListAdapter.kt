package com.ravn.challenge.presentation.home.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.ravn.challenge.R
import com.ravn.challenge.databinding.ItemPeopleBinding
import com.ravn.core.model.starwars.PeopleModel
import com.ravn.core.model.util.Event

class PeopleListAdapter(
    private var itemList: List<PeopleModel> = mutableListOf(),
    val itemClick: MutableLiveData<Event<PeopleModel>>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var isLoading = true

    fun setData(newList: List<PeopleModel>) {
        itemList = newList
        notifyDataSetChanged()
    }

    fun showProgressBar() {
        isLoading = true
    }

    fun hideProgressBar() {
        isLoading = false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            NORMAL_VIEW_TYPE -> {
                NormalItemVIewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_people,
                        parent,
                        false
                    )
                )
            }
            else -> {
                LoadingItemVIewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_loading,
                        parent,
                        false
                    )
                )
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when {
            holder is NormalItemVIewHolder -> {
                holder.bindData(itemList[position], itemClick)
            }
            holder is LoadingItemVIewHolder -> {
                // Nothing To Do Here
            }
        }
    }

    override fun getItemCount(): Int = if (isLoading) {
        itemList.count() + 1
    } else {
        itemList.count()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int =
        if (position < itemList.size) {
            NORMAL_VIEW_TYPE
        } else {
            LOADING_VIEW_TYPE
        }

    class NormalItemVIewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemPeopleBinding? = DataBindingUtil.bind(view)
        fun bindData(
            item: PeopleModel,
            itemClickEvent: MutableLiveData<Event<PeopleModel>>
        ) {
            binding?.viewModel =
                PeopleListItemViewModel(
                    item,
                    itemClickEvent
                )
            binding?.viewModel?.bindData()
        }
    }

    class LoadingItemVIewHolder(view: View) : RecyclerView.ViewHolder(view)

    companion object {
        const val NORMAL_VIEW_TYPE = 1
        const val LOADING_VIEW_TYPE = 2
    }
}
