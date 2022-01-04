package com.hh.s_model.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.hh.s_model.BuildConfig

/**
 * @ProjectName: s_model
 * @Package: com.hh.s_model.base
 * @Description: 类描述
 * @Author: huanghai
 * @CreateDate: 2021/12/27  14:26
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this)
    }
}