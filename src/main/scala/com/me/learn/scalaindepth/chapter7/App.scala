package com.me.learn.scalaindepth.chapter7

/**
  * Created by senyuanwang on 2016/10/15.
  */
object App extends App {

  val l: String Or Int = Left("boo")
  val r: String Or Int = Right(13)

  println(l.left.map(_.size))

  println(r.left.map(_.size))
}
