package com.hh.s_model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.hh.common.bean.TestARouterBean
import java.io.Serializable

@Route(path = MainActivity.PATH)
class MainActivity : AppCompatActivity() {
    companion object {
        const val PATH = "/s_model/MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //可以定义拦截器在找不到时候触发

    fun startOrder(view: View){
        if(BuildConfig.isRelease){
            val bean = TestARouterBean(1,"asd")
            ARouter.getInstance().build("/h_order/OrderMainActivity")
                .withString("from", "ysn")
                .withSerializable("bean",bean as Serializable)
                .navigation(this,object : NavigationCallback{
                    override fun onFound(postcard: Postcard?) {
                        Log.d("ARouter", "找到了");
                    }

                    override fun onLost(postcard: Postcard?) {
                        Log.d("ARouter", "找不到了");
                    }

                    override fun onArrival(postcard: Postcard?) {
                        Log.d("ARouter", "跳转完了");
                    }

                    override fun onInterrupt(postcard: Postcard?) {
                        Log.d("ARouter", "被拦截了");
                    }
                })
        }
        else{
            Toast.makeText(this,"订单",Toast.LENGTH_SHORT).show()
        }
    }

    fun startShop(view: View){
        if(BuildConfig.isRelease){
            ARouter.getInstance().build("/h_shop/ShopMainActivity").navigation()
        }
        else{
            Toast.makeText(this,"商城",Toast.LENGTH_SHORT).show()
        }
    }

}