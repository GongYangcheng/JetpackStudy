package com.bhyf.jetpackstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.bhyf.jetpackstudy.useless.DataBindingTest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_to_data_b_a.setOnClickListener(this)
//        Utils.
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_to_data_b_a -> startActivity(Intent(this, DataBindingTest::class.java))
//            R.id.btn_to_data_b_a -> startActivity(Intent(this,DataBindingTest::class.java))
//            R.id.btn_to_data_b_a -> startActivity(Intent(this,DataBindingTest::class.java))
//            R.id.btn_to_data_b_a -> startActivity(Intent(this,DataBindingTest::class.java))
        }
    }
}