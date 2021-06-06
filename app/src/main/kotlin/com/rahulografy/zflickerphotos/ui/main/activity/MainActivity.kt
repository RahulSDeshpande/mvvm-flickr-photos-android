package com.rahulografy.zflickerphotos.ui.main.activity

import com.google.android.material.snackbar.Snackbar
import com.rahulografy.zflickerphotos.BR
import com.rahulografy.zflickerphotos.R
import com.rahulografy.zflickerphotos.databinding.ActivityMainBinding
import com.rahulografy.zflickerphotos.ui.base.view.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    override val layoutRes: Int get() = R.layout.activity_main

    override val viewModelClass get() = MainActivityViewModel::class.java

    override val bindingVariable get() = BR._all

    override fun initUi() {}

    fun showSnackbar(message: String) {
        Snackbar
            .make(
                coordinatorLayoutMain,
                message,
                Snackbar.LENGTH_LONG
            ).show()
    }
}
