package com.hh.s_model

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

/**
 * @ProjectName: s_model
 * @Package:
 * @Description: 类描述
 * @Author: huanghai
 * @CreateDate: 2021/12/28  10:07
 */
//定义一个拦截器，需要name随便写一个即可
@Interceptor(name = "/s_model/interceptor", priority = 9)
class GlobalInterceptor : IInterceptor {

    private var context: Context? = null

    override fun init(context: Context?) {
        this.context = context
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        Log.d("ARouter", "找到了");
        //错误后失效的时间
        postcard?.timeout = 1
        val flag = postcard?.extra
        if (flag?.and(RouteFlag.FLAG_LOGIN) != 0) {
            //判断是否已经登录
//            val isLogin = LoginRepositoryProvider.getInstance().isLogin()
            val isLogin = false
            if (!isLogin) {
//                ARouter.getInstance().build(LoginActivity.PATH)
//                    .navigation()
                showToast()
            } else {
                //已经登录不需要拦截
                callback?.onContinue(postcard)
            }
        } else {
            //不需要拦截
            callback?.onContinue(postcard)
        }
    }

    object RouteFlag {
        //为什么可以使用route注解的extra参数为目标页指定属性
        //因为Int数值在内存中占4个字节，每个字节占8位，所以利用extras字段我们可以为目标页指定32个开关
        const val FLAG_LOGIN: Int = 0x01
        const val FLAG_AUTHORITY = FLAG_LOGIN.shl(1)//等同于java中的FLAG_LOGIN<<1
        const val FLAG_VIP = FLAG_AUTHORITY.shl(1)
    }

    private fun showToast(msg: String = "需要登录") {
        //拦截器在子线程中，需要切换到主线程更新UI
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

}
