package codechef.easy.oraclcs

import scala.io.StdIn

/**
  * Created by wangsenyuan on 27/04/2017.
  */
object Main {


  def solve() = {
    val n = StdIn.readInt()
    var i = 0
    var a = Int.MaxValue
    var b = Int.MaxValue
    while (i < n) {
      val s = StdIn.readLine()
      val x = s.count(_ == 'a')
      val y = s.length - x

      a = a min x
      b = b min y

      i += 1
    }

    println(a min b)

  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }
}
