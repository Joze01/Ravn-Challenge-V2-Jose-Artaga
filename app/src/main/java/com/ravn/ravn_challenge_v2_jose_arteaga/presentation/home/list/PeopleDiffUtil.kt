package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.home.list

import androidx.recyclerview.widget.DiffUtil
import com.ravn.core.model.starwars.PeopleModel


class PeopleDiffUtil(
    private val oldList: List<PeopleModel>,
    private val newList: List<PeopleModel>,
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun getOldListSize() = oldList.count()

    override fun getNewListSize() = newList.count()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]

    }
}