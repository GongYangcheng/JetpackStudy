package com.bhyf.jetpackstudy.useless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bhyf.jetpackstudy.R
import com.bhyf.jetpackstudy.databinding.ActivityDataBindingTestBinding

class DataBindingTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataBindingUtil:ActivityDataBindingTestBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_data_binding_test
        )
        dataBindingUtil.vm = UserViewModel()

    }
}