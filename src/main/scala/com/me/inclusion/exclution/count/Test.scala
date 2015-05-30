package com.me.inclusion.exclution.count

/**
 * Created by senyuanwang on 15/5/29.
 */
object Test extends App with InExPriciple {

  println(count(Array(2, 3), 100))

  println(count(Array(2, 3, 7), 100))
}
