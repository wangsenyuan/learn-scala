package com.me.learn.algorithm.design.analysis

/**
 * Created by senyuanwang on 15/6/12.
 */
object Permutations {

  def johnsonTrotter(n: Int): List[List[Int]] = {
    case class X(d: Boolean, v: Int, i: Int) {
      def isMobile(xs: Array[X]): Boolean =
        if (d && i > 0) xs(i - 1).v < v
        else if (!d && i < n - 1) v > xs(i + 1).v
        else false

      def swapIn(xs: Array[X]): Array[X] = {
        val j = if (d) i - 1 else i + 1
        val y = xs(j)
        val nx = this.copy(i = j)
        val ny = y.copy(i = this.i)
        xs(i) = ny
        xs(j) = nx
        xs
      }
    }

    val xs = new Array[X](n)

    for (i <- 0 until n) {
      xs(i) = X(true, i, i)
    }

    def reverse(xs: Array[X], t: Int): Array[X] = {
      for {
        i <- 0 until n
        x = xs(i)
        if (x.v > t)
      } {
        xs(i) = x.copy(d = !x.d)
      }
      xs
    }

    def findMaxMobile(xs: Array[X], i: Int, result: Option[X]): Option[X] =
      if (i == n) result
      else {
        val x = xs(i)
        if (!x.isMobile(xs)) {
          findMaxMobile(xs, i + 1, result)
        } else {
          result match {
            case Some(y) if (y.v > x.v) => findMaxMobile(xs, i + 1, result)
            case _ => findMaxMobile(xs, i + 1, Some(x))
          }
        }
      }

    def toList(xs: Array[X]): List[Int] = xs.toList.map(_.v)

    def gen(xs: Array[X], result: List[List[Int]]): List[List[Int]] =
      findMaxMobile(xs, 0, None) match {
        case None => result.reverse
        case Some(x) =>
          gen(reverse(x.swapIn(xs), x.v), toList(xs) :: result)
      }

    gen(xs, List(toList(xs)))
  }
}
