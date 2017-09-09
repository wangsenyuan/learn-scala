package codechef.easy.strsub

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val q = firstLine(2)
    val str = StdIn.readLine()
    val far = preComputeFar(str, n, k)
    val raf = preComputeRaf(str, n, k)

    val sum = Array.fill(n + 1)(0L)

    var i = 0
    while (i < n) {
      sum(i + 1) = sum(i) + far(i)
      i += 1
    }

    i = 0
    while (i < q) {
      val query = StdIn.readLine().split("\\s+").map(_.toInt)
      val l = query(0) - 1
      val r = query(1) - 1

      val a = raf(r) - 1

      val ans =
        if (l <= a) {
          sum(a + 1) - sum(l) + 1l * (r - a) * r - 1l * (l + r - 2) * (r - l + 1) / 2
        } else {
          1l * (r - l + 2) * (r - l + 1) / 2
        }

      println(ans)

      i += 1
    }
  }

  def preComputeFar(str: String, n: Int, k: Int): Array[Int] = {
    val res = Array.fill(n)(0)
    val cnt = Array.fill(2)(0)
    var j = 0
    var i = 0

    while (i < n) {
      while (j < n && cnt(str(j) - '0') + 1 <= k) {
        cnt(str(j) - '0') += 1
        j += 1
      }
      res(i) = j - 1
      cnt(str(i) - '0') -= 1

      i += 1
    }

    res
  }

  def preComputeRaf(str: String, n: Int, k: Int): Array[Int] = {
    val res = Array.fill(n)(0)
    val cnt = Array.fill(2)(0)
    var j = n - 1
    var i = n - 1
    while (i >= 0) {
      while (j >= 0 && cnt(str(j) - '0') + 1 <= k) {
        cnt(str(j) - '0') += 1
        j -= 1
      }
      res(i) = j + 1
      cnt(str(i) - '0') -= 1
      i -= 1
    }

    res
  }
}
