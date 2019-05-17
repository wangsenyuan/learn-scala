package set600.set660.p667

import scala.annotation.tailrec

object Solution {

  def constructArray(n: Int, k: Int): Array[Int] = {
    val nums = Array.ofDim[Int](n)

    if(k == 1) {
      var i = 0
      while(i < n) {
        nums(i) = i + 1
        i += 1
      }
    } else if(k == 2) {
      nums(0) = 1
      nums(1) = n
      var i = 2
      while(i < n) {
        nums(i) = n + 1 - i
        i += 1
      }
    } else {
      var a = 1
      var b = n
      var i = 0
      while(i < k) {
        if(i % 2 == 0) {
          nums(i) = a
          a += 1
        } else {
          nums(i) = b
          b -= 1
        }
        i += 1
      }

      if(nums(i - 1) + 1 == a) {
        while(i < n) {
          nums(i) = a
          a += 1
          i += 1
        }
      } else {
        while(i < n) {
          nums(i) = b
          b -= 1
          i += 1
        }
      }

    }

    nums
  }

  def constructArray1(n: Int, k: Int): Array[Int] = {
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
