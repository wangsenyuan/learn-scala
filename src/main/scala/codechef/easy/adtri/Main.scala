package codechef.easy.adtri

import java.util

import scala.io.StdIn

/**
  * Created by wangsenyuan on 22/03/2017.
  */
object Main {

  def preCompute(n: Int) = {
    val res = Array.fill(n + 1)(false)
    val set = new util.BitSet()
    var x = 2
    while (x <= n) {
      x = set.nextClearBit(x)
      if (x % 4 == 1) {
        var y = x
        while (y <= n) {
          res(y) = true
          y += x
        }
      }
      var y = 2 * x
      while (y <= n) {
        set.set(y)
        y += x
      }
      x += 1
    }

    res
  }

  def main(args: Array[String]): Unit = {

    val xs = preCompute(5 * 1000000)

    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()

      if (xs(n)) {
        println("YES")
      } else {
        println("NO")
      }

      t -= 1
    }
  }
}
