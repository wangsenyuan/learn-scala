package codechef.easy.divmac

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/4/3.
  */
object Main {

  val N = 100100

  def preCompute(N: Int): Array[Int] = {
    val lp = Array.fill(N * 10)(0)
    val primes = ListBuffer.empty[Int]
    lp(1) = 1
    var i = 2
    while (i < 10 * N) {
      if (lp(i) == 0) {
        primes += i
        lp(i) = i
      }

      var j = 0
      while (j < primes.length && primes(j) <= lp(i) && i * primes(j) < 10 * N) {
        lp(i * primes(j)) = primes(j)
        j += 1
      }

      i += 1
    }

    lp
  }

  val lp = preCompute(N)

  def solve(lp: Array[Int]) = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)

    val nums = StdIn.readLine().split("\\s+").map(_.toInt)
    val valid = ListBuffer.empty[Int]
    var i = 0
    while (i < n) {
      if (nums(i) > 1) {
        valid += (i + 1)
      }
      i += 1
    }

    var seg = buildSegTree(1, n, nums)

    i = 0
    var res = Vector.empty[Int]
    while (i < m) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val op = line(0)
      val a = line(1)
      val b = line(2)
      if (op == 0) {
        seg = updateSegTree(seg, a, b, valid, nums)
      } else {
        res :+= seg.getMax(a, b)
      }
      i += 1
    }

    println(res.mkString(" "))
  }


  def updateSegTree(seg: SegTree, a: Int, b: Int, valid: ListBuffer[Int], nums: Array[Int]) = {
    var resSeg = seg
    var x = binarySearch(valid, a)
    val invalid = ListBuffer.empty[Int]
    while (x < valid.length && valid(x) <= b) {
      val y = valid(x)
      val v = lp(nums(y - 1))
      nums(y - 1) /= v
      val w = lp(nums(y - 1))
      resSeg = resSeg.update(y, w)
      if (nums(y - 1) == 1) {
        invalid += x
      }
      x += 1
    }

    var i = 0
    while (i < invalid.length) {
      valid.remove(invalid(i))
      i += 1
    }
    resSeg
  }

  def binarySearch(valid: ListBuffer[Int], a: Int) = {
    var i = 0
    var j = valid.length
    while (i < j) {
      val mid = (i + j) >> 1
      if (valid(mid) < a) {
        i = mid + 1
      } else {
        j = mid
      }
    }
    i
  }


  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve(lp)
      i += 1
    }
  }

  case class SegTree(li: Int, ri: Int, value: Int, left: SegTree, right: SegTree) {

    def update(idx: Int, v: Int): SegTree = {
      if (li == ri) {
        this.copy(value = v)
      } else {
        val mid = (li + ri) >> 1
        val lf =
          if (idx <= mid) {
            left.update(idx, v)
          } else {
            left
          }
        val rf =
          if (idx > mid) {
            right.update(idx, v)
          } else {
            right
          }
        SegTree(lf, rf)
      }
    }

    def getMax(l: Int, r: Int): Int = {
      if (l > r) {
        1
      } else if (li == l && ri == r) {
        this.value
      } else {
        val mid = (li + ri) >> 1
        left.getMax(l, r min mid) max right.getMax((mid + 1) max l, r)
      }
    }
  }

  object SegTree {
    def apply(left: SegTree, right: SegTree): SegTree = {
      SegTree(left.li, right.ri, left.value max right.value, left, right)
    }
  }

  def buildSegTree(li: Int, ri: Int, nums: Array[Int]): SegTree = {
    if (li == ri) {
      SegTree(li, ri, lp(nums(li - 1)), null, null)
    } else {
      val mid = (li + ri) >> 1
      val left = buildSegTree(li, mid, nums)
      val right = buildSegTree(mid + 1, ri, nums)
      SegTree(left, right)
    }
  }
}
