package codechef.easy.forgetpw

import scala.io.StdIn

/**
  * Created by wangsenyuan on 24/03/2017.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val mapping = (0 to 128).toArray
    var i = 0
    while (i < n) {
      val line = StdIn.readLine()
      val src = line(0)
      val dst = line(2)
      mapping(src) = dst
      i += 1
    }

    val str = StdIn.readLine().toCharArray
    val aft = Array.fill(str.length)(0)

    i = 0
    while (i < str.length) {
      val src = str(i)
      aft(i) = mapping(src)
      i += 1
    }

    i = 0
    while (i < aft.length && aft(i) == '0') {
      i += 1
    }

    if (i == aft.length) {
      //all zero
      println(0)
    } else {
      val a = i

      while (i < aft.length && aft(i) != '.') {
        i += 1
      }

      if (i == aft.length) {
        //no dot found
        val res = new String(aft, a, aft.length - a)
        println(res)
      } else {
        i = aft.length - 1
        while (i >= 0 && aft(i) == '0') {
          i -= 1
        }
        if (aft(i) == '.') {
          i -= 1
        }
        val b = i
        if (b < a) {
          println(0)
        } else {
          val res = new String(aft, a, b - a + 1)
          println(res)
        }
      }
    }

  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve();
      i += 1
    }
  }
}
