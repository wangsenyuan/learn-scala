package com.me.learn.implicits

/**
  * Created by senyuanwang on 16/9/24.
  */
object ImplicitEvidence extends App {

  object M {
    implicit object AMarker
    implicit object BMarker

    def m(ints: Seq[Int])(implicit i: AMarker.type ): Unit = {
      println(s"int seq $ints");
    }

    def m(strs: Seq[String])(implicit s: BMarker.type ): Unit = {
      println(s"string seq $strs")
    }
  }

  import M._

  m(Seq(1, 2, 3))
  m(Seq("a", "b", "c"))
}
