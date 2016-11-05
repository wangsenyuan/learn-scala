package com.me.learn.scalaindepth.chapter14

/**
  * Created by senyuanwang on 2016/11/3.
  */
object App extends App {

  object Serialization {

    case class Rem[A](value: A) {
      def serialized: String = s"---$value---"
    }

    type Writable[A] = A => Rem[A]

    implicit val fromInt: Writable[Int] = (i: Int) => Rem(i)
    implicit val fromFloat: Writable[Float] = (f: Float) => Rem(f)
  }

  import Serialization._

  object RemoteConnection {
    def write[T: Writable](t: T): Unit = {
      //val proof = implicitly[Writable[T]]
      println(t.serialized)
    }
  }

  RemoteConnection.write(1)
}
