package com.ravn.challenge.base

import androidx.annotation.LayoutRes
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.ravn.challenge.BR

abstract class BaseActivity : AppCompatActivity() {
    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    abstract val viewModel: ViewModel?

    fun <Binding : ViewDataBinding> getBindedView(
        @LayoutRes layoutId: Int,
    ): Binding {
        val binding = DataBindingUtil.setContentView<Binding>(this, layoutId)
        binding.apply {
            lifecycleOwner = this@BaseActivity
            viewModel?.let { setVariable(BR.viewModel, it) }
        }
        return binding
    }
}
