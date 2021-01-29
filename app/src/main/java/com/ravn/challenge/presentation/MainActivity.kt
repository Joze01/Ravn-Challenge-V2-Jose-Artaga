package com.ravn.challenge.presentation

import android.os.Bundle
import com.ravn.challenge.R
import com.ravn.challenge.base.BaseActivity
import com.ravn.challenge.databinding.ActivityMainBinding
import com.ravn.challenge.presentation.util.setObserver
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    override val viewModel: SharedViewModel by viewModel()

    lateinit var binding: ActivityMainBinding

    // The MainActivity just contains the FragmentHost that haves the navigation graph
    // This is to have a SingleActivityApplication and simplify some things
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getBindedView(R.layout.activity_main)
        actionBar?.setHomeButtonEnabled(true)
        viewModel.screenTitle.setObserver(this, ::bindTittleToView)
    }

    fun bindTittleToView(title: String) {
        this.title = title
    }
}
