package com.bhyf.jetpackstudy.loginmvc

import android.text.TextUtils
import com.bhyf.jetpackstudy.Utils
import java.util.Random

class UserModel {
    private val random: Random = Random()

    companion object{
        const val STATE_LOGIN_LOADING = 0
        const val STATE_LOGIN_SUCCESS = 1
        const val STATE_LOGIN_FAILED = 2
    }
    fun checkUserState(account: String, block: (Int) -> Unit) {
//        0表示该账号已注册，1：表示该账号没有进行注册
        block.invoke(random.nextInt(2))

    }

    fun doLogin(account: String, psd: String,block: (Int) -> Unit) {

        block.invoke(STATE_LOGIN_LOADING)
        val randomValue = random.nextInt(2)
        if (randomValue == 0) {
            block.invoke(STATE_LOGIN_SUCCESS)
        }else{
            block.invoke(STATE_LOGIN_FAILED)
        }
    }
}