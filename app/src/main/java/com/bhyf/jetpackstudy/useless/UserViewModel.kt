package com.bhyf.jetpackstudy.useless

import android.util.Log
import androidx.databinding.ObservableField

/**
 * model 继承ViewModel
 */
class UserViewModel  {
    private var user: User? = null
    private var observableField:ObservableField<User>?  = null

    constructor(){
        this.user = User("Tom")
        observableField = ObservableField();
        observableField?.set(user)
    }

    fun getUserNameO():String{
        return observableField?.get()?.userName!!
    }

    fun setUserNameO(name :String){
        Log.d("ddd", "setUserNameO: $name")
        observableField?.get()?.userName = name
    }
//    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//    @Bindable
//    fun getUserName():String{
//        return user?.userName!!
//    }
//
////    EditText内容发生变化，就会调用
//    fun setUserName(name:String){
//        if (name != null && name != user?.userName) {
//            user?.userName = name
//            Log.d("ddd", "setUserName: ${user?.userName}")
////            notifyPropertyChanged(BR._all)
//        }
//    }
}