package p667

import scala.annotation.tailrec

object Solution {

  def constructArray(n: Int, k: Int): Array[Int] = {
    val res = Array.fill(n)(0)

    @tailrec
    def go(i: Int, j: Int, k: Int, a: Int): Unit = {
      val nk =
        if (k > 1) {
          k - 1
        } else {
          k
        }
      if (i <= j) {
        if (k % 2 == 1) {
          res(a) = i
          go(i + 1, j, nk, a + 1)
        } else {
          res(a) = j
          go(i, j - 1, nk, a + 1)
        }
      }
    }

    go(1, n, k, 0)

    res
  }

  def main(args: Array[String]): Unit = {
    println(constructArray(6, 5).mkString(" "))
    println(constructArray(6, 4).mkString(" "))
    println(constructArray(6, 3).mkString(" "))
    println(constructArray(6, 2).mkString(" "))
    println(constructArray(6, 1).mkString(" "))
  }
}
