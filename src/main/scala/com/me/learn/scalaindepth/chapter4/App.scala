package com.me.learn.scalaindepth.chapter4

/**
 * Created by senyuanwang on 15/6/12.
 */
object App extends App {
  val x = new Property {
    override val name = "Hi"
  }

  println(x)

  class X extends Property {
    override val name = "Hi"
  }

  val x1 = new X

  println(x1)

  class Y extends {val name = "Hi"} with Property

  val y = new Y

  println(y)
}
