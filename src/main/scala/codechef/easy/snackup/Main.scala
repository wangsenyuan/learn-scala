package codechef.easy.snackup

import scala.io.StdIn

/**
  * Created by wangsenyuan on 21/06/2017.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()

    def invite(x: Int, y: Int): Unit = {
      var i = 0
      while (i < n) {
        val a = (x + i) % n
        val b = (y + i) % n
        println(s"${a + 1} ${b + 1} ${(b + 1) % n + 1}")
        i += 1
      }
    }

    println(n)

    var i = 0
    while (i < n) {
      println(n)
      invite(i, 0)
      i += 1
    }
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
