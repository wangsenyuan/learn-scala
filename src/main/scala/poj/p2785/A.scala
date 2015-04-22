package poj.p2785

import java.util

import scala.io.StdIn

/**
 * Created by senyuanwang on 15/4/19.
 */
object A extends App {

  def solve(as: Array[Long], bs: Array[Long], cs: Array[Long], ds: Array[Long], n: Int): Int = {

    var cds = Array.fill(n * n)(0L)

    for {
      i <- 0 until n
      j <- 0 until n
    } {
      cds(i * n + j) = cs(i) + ds(j)
    }

    cds = cds.sorted

    (0 until n).foldLeft(0) {
      (res, i) =>
        (0 until n).foldLeft(res) {
          (res, j) =>
            val cd = -(as(i) + bs(j))
            val idx = Main.upperBound(cds, cd) - Main.lowerBound(cds, cd)
            if (idx >= 0) {
              res + 1
            } else {
              res
            }
        }
    }
  }

  val n = StdIn.readLine().toInt
  val as = Array.fill(n)(0L)
  val bs = Array.fill(n)(0L)
  val cs = Array.fill(n)(0L)
  val ds = Array.fill(n)(0L)

  for {
    i <- 0 until n
    line = StdIn.readLine().split("\\s+").map(_.toLong)
  } {
    as(i) = line(0)
    bs(i) = line(1)
    cs(i) = line(2)
    ds(i) = line(3)
  }

  val res = solve(as, bs, cs, ds, n)

  println(res)
}
