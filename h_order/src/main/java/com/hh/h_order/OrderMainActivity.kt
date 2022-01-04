package com.hh.h_order

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.hh.common.CommonUtils
import com.hh.common.bean.TestARouterBean

@Route(path = "/h_order/OrderMainActivity")
class OrderMainActivity : AppCompatActivity() {

    @JvmField
    @Autowired
    var from = ""

    @JvmField
    @Autowired
    var bean : TestARouterBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_main_activity)
        CommonUtils.getStatus()
        //设置参数的自动注入
        ARouter.getInstance().inject(this)
        //打印
        Log.d("OrderMainActivity", "onCreate: from=$from")
        bean?.apply {
            Log.d("OrderMainActivity", "onCreate: bean=id:$id title:$title")
        }
//        val fragment: Fragment =
//            ARouter.getInstance().build("/test/fragment").navigation() as Fragment //获取Fragment


    }
}