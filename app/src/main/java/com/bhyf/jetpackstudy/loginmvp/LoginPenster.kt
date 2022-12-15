package com.bhyf.jetpackstudy.loginmvc

import android.text.TextUtils
import com.bhyf.jetpackstudy.loginmvc.UserModelP.Companion.STATE_LOGIN_FAILED
import com.bhyf.jetpackstudy.loginmvc.UserModelP.Companion.STATE_LOGIN_LOADING
import com.bhyf.jetpackstudy.loginmvc.UserModelP.Companion.STATE_LOGIN_SUCCESS

/**
 * mvc->mvp
 * loginControl演变过来的
 */
class LoginPenster {

    private val userModel by lazy {
        UserModelP()//懒加载，还有委托模式
    }

    fun checkAccountStateListener(account: String, callback: OnCherkAccountStateCallback) {
        userModel.checkUserState(account) {
            when (it) {
                0 -> {
//                    不可用，已经注册 TODO给出提示
                    callback.onExits()
                }
                1 -> {
//                      表示还没注册，可用，进行登录，此操作为异步
                    callback.onNoExits()
//                    userModel.doLogin(this, account, psd)
////                    禁止按钮可以点击，防止重复提交
//                    button.isEnabled = false
                }
            }
        }
    }

    interface OnCherkAccountStateCallback {
        fun onNoExits()
        fun onExits()
    }

    fun loginStateListener(
        account: String,
        psd: String,
        onLoginStateCallback: OnLoginStateCallback
    ) {
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(psd)) {
            onLoginStateCallback.onAccountOrPsdError()
        }
        userModel.doLogin(account,psd){
            when (it) {
                STATE_LOGIN_LOADING -> {onLoginStateCallback.onLoading()}
                STATE_LOGIN_SUCCESS -> {onLoginStateCallback.onSuccess()}
                STATE_LOGIN_FAILED -> {onLoginStateCallback.onFailed()}
                else -> {}
            }
        }

    }

    interface OnLoginStateCallback {
        fun onLoading()
        fun onSuccess()
        fun onFailed()
        fun onAccountOrPsdError()
    }

}