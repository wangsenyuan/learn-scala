package codechef.easy.chefck

import scala.io.StdIn

object Main {

  def fillA(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int, r: Int, s: Int, t: Int, m: Int, A: Array[Long], n: Int): Unit = {
    var u = t
    var i = 1
    while (i < n) {
      u = (u * t) % s
      if (u <= r) {
        A(i) = (1L * a * A(i - 1) * A(i - 1) + b * A(i - 1) + c) % m
      } else {
        A(i) = (1L * d * A(i - 1) * A(i - 1) + e * A(i - 1) + f) % m
      }

      i += 1
    }
  }


  def slidingWindow(A: Array[Long], n: Int, k: Int): Array[Long] = {
    val B = Array.fill(n)(Long.MaxValue)
    val stack = Array.fill(n)(0L)
    var head = 0
    var tail = 0
    var i = 0
    while (i < n) {
      val x = A(i)
      while (tail > head && stack(tail - 1) > x) {
        tail -= 1
      }

      stack(tail) = x
      tail += 1

      if (i >= k && stack(head) == A(i - k)) {
        head += 1
      }

      B(i) = stack(head)

      i += 1
    }

    B
  }

  val MOD = 1000000007

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val q = firstLine(2)

    val A = Array.fill(n)(0L)

    val secondLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val a = secondLine(0)
    val b = secondLine(1)
    val c = secondLine(2)
    val d = secondLine(3)
    val e = secondLine(4)
    val f = secondLine(5)
    val r = secondLine(6)
    val s = secondLine(7)
    val t = secondLine(8)
    val m = secondLine(9)
    A(0) = secondLine(10)

    fillA(a, b, c, d, e, f, r, s, t, m, A, n)

    val minEleArr = slidingWindow(A, n, k)

    //    val rmp = new RMQ(A)

    val thirdLine = StdIn.readLine().split("\\s+").map(_.toInt)
    var L1 = thirdLine(0)
    val La = thirdLine(1)
    val Lc = thirdLine(2)
    val Lm = thirdLine(3)
    var D1 = thirdLine(4)
    val Da = thirdLine(5)
    val Dc = thirdLine(6)
    val Dm = thirdLine(7)

    var sum = 0L
    var prod = 1L
    var i = 1
    while (i <= q) {
      L1 = ((1L * La * L1 + Lc) % Lm).toInt
      D1 = ((1L * Da * D1 + Dc) % Dm).toInt

      val L = L1 + 1
      val R = (L + k - 1 + D1) min n

      val minEle = minEleArr(L + k - 2) min minEleArr(R - 1)

      //      val minEle = rmp.query(L - 1, R - 1)
      sum += minEle
      prod = (prod * minEle) % MOD

      i += 1
    }

    println(s"$sum $prod")
  }

  private def log2(n: Int): Int = {
    var h = 0
    var m = 1
    while (m < n) {
      m = 2 * m
      h += 1
    }

    h
  }

  class RMQ(input: Array[Long]) {
    val n = input.length
    val h = log2(n)
    val size = (2 * math.pow(2, h) - 1).toInt
    val arr = Array.fill(size)(Long.MaxValue)

    private def construct(left: Int, right: Int, i: Int): Long = {
      if (left == right) {
        arr(i) = input(left)
      } else {
        val mid = left + (right - left) / 2
        arr(i) = construct(left, mid, 2 * i + 1) min construct(mid + 1, right, 2 * i + 2)
      }
      arr(i)
    }

    construct(0, n - 1, 0)

    def query(left: Int, right: Int): Long = {
      def go(l: Int, r: Int, i: Int): Long = {
        if (r < left || l > right) {
          Long.MaxValue
        } else if (left <= l && r <= right) {
          arr(i)
        } else {
          val mid = l + (r - l) / 2
          go(l, mid, 2 * i + 1) min go(mid + 1, r, 2 * i + 2)
        }
      }

      go(0, n - 1, 0)
    }
  }

}
