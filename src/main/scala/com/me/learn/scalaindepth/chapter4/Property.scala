package com.me.learn.scalaindepth.chapter4

/**
 * Created by senyuanwang on 15/6/12.
 */
trait Property {
  val name: String

  override val toString = "Property(" + name + ")"
}
