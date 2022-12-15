package com.bhyf.jetpackstudy.loginmvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnClickListener
import androidx.core.widget.addTextChangedListener
import com.bhyf.jetpackstudy.R
import com.bhyf.jetpackstudy.Utils
import kotlinx.android.synthetic.main.activity_login.*

class LoginPActivity : AppCompatActivity() ,OnClickListener,
    LoginPenster.OnCherkAccountStateCallback, LoginPenster.OnLoginStateCallback {

    private val loginController by lazy {
        LoginPenster()
    }
    private var isNameCanBeUse = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button.setOnClickListener(this)
        button2.setOnClickListener(this)
        initListener()
    }

    private fun initListener() {
        edt_account.addTextChangedListener( object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loginController.checkAccountStateListener(s.toString(),this@LoginPActivity)
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        edt_psd.addTextChangedListener {

        }
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.button -> {
//                登录
                toLogin()
            }
            R.id.button2 ->{
//                注册
            }
        }
    }

    private fun toLogin() {
        var account = edt_account.text.toString()
        var psd = edt_psd.text.toString()
//        给密码加盐（加密）
        if (isNameCanBeUse) {
//            不能已经注册 不能再注册return
        }
        loginController.loginStateListener(
            account,
            psd,
            this
        )

    }

    override fun onNoExits() {
//        不存在账户，可注册
        textView3.text = "可以注册"
    }

    override fun onExits() {
//        账户已存在,不可重复注册
        textView3.text = "账户已存在"
    }

    override fun onLoading() {
        textView3.text = "登陆中。。。"
//        textView3.text = "登陆中。。。"
    }

    override fun onSuccess() {
        textView3.text = "登陆成功"

    }

    override fun onFailed() {
        textView3.text = "登陆失败"
    }

    override fun onAccountOrPsdError() {
        textView3.text = "账户或密码不能为空"
        Utils.toastShow(this,"账户或密码不能为空")
    //处理账号密码不能为空34000-5762-6684-8398//1月底10000//3912
//        20000-4600-5762 2月底//9000   674 //5726 2
//        21000-5762-674  3月底//14591
    }
}