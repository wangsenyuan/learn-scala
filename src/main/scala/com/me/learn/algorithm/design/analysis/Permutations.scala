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

  def lexicographicPermute(n: Int): List[List[Int]] = {
    def findLargestIndexI(nums: Array[Int], i: Int): Option[Int] =
      if (i < 0) None
      else if (nums(i) < nums(i + 1)) Some(i)
      else findLargestIndexI(nums, i - 1)

    def findLargestIndexJ(nums: Array[Int], i: Int): Int = {
      (i + 1 until nums.length).foldLeft(i + 1) {
        (j, k) =>
          if (nums(i) < nums(k)) k
          else j
      }
    }

    def swapIJ(nums: Array[Int], i: Int, j: Int) = {
      val tmp = nums(i)
      nums(i) = nums(j)
      nums(j) = tmp
    }

    def reverseBetweenIJ(nums: Array[Int], i: Int, j: Int): Unit = {
      if (i < j) {
        swapIJ(nums, i, j)
        reverseBetweenIJ(nums, i + 1, j - 1)
      }
    }

    def go(nums: Array[Int], result: List[List[Int]]): List[List[Int]] = {
      val nresult = (nums.toList :: result)
      findLargestIndexI(nums, nums.length - 2) match {
        case None => nresult
        case Some(i) =>
          val j = findLargestIndexJ(nums, i)
          swapIJ(nums, i, j)
          reverseBetweenIJ(nums, i + 1, nums.length - 1)
          go(nums, nresult)
      }
    }

    val nums = Array.fill(n)(0)
    for (i <- 0 until n) nums(i) = i

    go(nums, Nil).reverse
  }

  def brgc(n: Int): List[List[Int]] = {
    if (n == 1) List(List(0), List(1))
    else {
      val list = brgc(n - 1)
      val rlist = list.reverse
      list.map(0 :: _) ++ rlist.map(1 :: _)
    }
  }
}
