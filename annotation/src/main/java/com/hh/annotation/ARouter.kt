package com.hh.annotation


@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS) //作用域 类
@kotlin.annotation.Retention(AnnotationRetention.SOURCE) // 编译期生效
annotation class ARouter (val path: String, val group: String = "")