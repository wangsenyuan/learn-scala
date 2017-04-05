package codechef.easy.shiro

import scala.io.StdIn

/**
  * Created by wangsenyuan on 05/04/2017.
  */
object Main {

  val OFFSET = 10000

  val prop = Array.fill(2, 2 * (OFFSET + 2))(0.0)

  def solve() = {
    val n = StdIn.readInt()
    val as = StdIn.readLine().split("\\s+").map(_.toInt)
    val ps = StdIn.readLine().split("\\s+").map(_.toInt * 0.01D)

    prop(0)(OFFSET) = 1.0

    var u = 0
    var v = 1
    var maxL = 0

    var i = 0
    while (i < n) {
      val nMaxL = maxL + as(i)
      var j = -nMaxL
      while (j <= nMaxL) {
        prop(v)(j + OFFSET) = 0.0

        if (-maxL <= j + as(i) && j + as(i) <= maxL) {
          prop(v)(j + OFFSET) += (1.0 - ps(i)) * prop(u)(j + as(i) + OFFSET)
        }

        if (-maxL <= j - as(i) && j - as(i) <= maxL) {
          prop(v)(j + OFFSET) += ps(i) * prop(u)(j - as(i) + OFFSET)
        }
        j += 1
      }

      maxL = nMaxL
      u = 1 ^ u
      v = 1 ^ v

      i += 1
    }

    var res = 0.0D

    i = 0
    while (i <= maxL) {
      res += prop(u)(i + OFFSET)
      i += 1
    }

    println(f"$res%.7f")
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
