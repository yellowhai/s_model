package com.hh.common.bean

import java.io.Serializable

/**
 * @ProjectName: s_model
 * @Package: com.hh.common.bean
 * @Description: 类描述
 * @Author: huanghai
 * @CreateDate: 2021/12/27  16:50
 */
class TestARouterBean () : Serializable{
    var id : Int? = null
    var title : String ? = null
    constructor(i : Int,s :String): this() {
        id = i
        title = s
    }
}