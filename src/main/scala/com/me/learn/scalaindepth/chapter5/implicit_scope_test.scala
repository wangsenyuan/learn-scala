package com.me.learn.scalaindepth.chapter5

/**
 * Created by senyuanwang on 15/6/13.
 */
object implicit_scope_test extends App {

  object holder {
    trait Foo
    object Foo {
      implicit val x = new Foo {
        override def toString = "Companion Foo"
      }

      implicit val list = List(new Foo{})
    }
  }

  import holder.Foo

  def method(implicit foo: Foo) = println(foo)

  method

  val implicitList = implicitly[List[Foo]]

  println(implicitList)
}
