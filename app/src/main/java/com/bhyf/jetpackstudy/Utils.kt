package com.bhyf.jetpackstudy

import android.content.Context
import android.util.Log
import android.widget.Toast

/**
 * kotlin 的静态方法和变量怎么使用？
 */
class Utils {
    companion object{
        val TAG = "ddd"
        fun toastShow(context: Context, msg:String){
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
        }

        open fun logD(msg:String){
            Log.d(TAG, "logD: $msg")
        }
    }

}