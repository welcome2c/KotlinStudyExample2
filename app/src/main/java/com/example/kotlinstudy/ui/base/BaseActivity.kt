package com.example.kotlinstudy.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity<B: ViewDataBinding>(
    private val layoutId: Int
) : AppCompatActivity() {

    private lateinit var viewDataBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        viewDataBinding.lifecycleOwner = this
    }

    protected fun binding(action: B.() -> Unit) {
        viewDataBinding.run(action)
    }
}