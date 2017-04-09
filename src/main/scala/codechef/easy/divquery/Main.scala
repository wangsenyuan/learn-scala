package codechef.easy.divquery

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/04/2017.
  */
object Main {

  val MAX_D = 100000

  def preComputeDivs(): Array[Array[Int]] = {
    val res = Array.fill[ListBuffer[Int]](MAX_D + 1)(null)
    res(0) = ListBuffer.empty[Int]
    var i = 1
    while (i <= MAX_D) {
      var j = i
      while (j <= MAX_D) {
        if (res(j) == null) {
          res(j) = ListBuffer.empty[Int]
        }
        res(j) += i
        j += i
      }

      i += 1
    }

    res.map(_.toArray)
  }

  def binarySearch(len: Int, f: Int => Boolean): Int = {
    var i = 0
    var j = len
    while (i < j) {
      val k = (i + j) / 2
      if (!f(k)) {
        i = k + 1
      } else {
        j = k
      }
    }
    i
  }

  def main(args: Array[String]): Unit = {
    val divs = preComputeDivs()
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val q = line(1)
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)
    val bucket = Array.fill[ListBuffer[Int]](MAX_D + 1)(null)
    var i = 0
    while (i < n) {
      var j = 0
      while (j < divs(nums(i)).length) {
        val d = divs(nums(i))(j)
        if (bucket(d) == null) {
          bucket(d) = ListBuffer.empty[Int]
        }
        bucket(d) += i
        j += 1
      }

      i += 1
    }

    i = 0
    while (i < q) {
      val que = StdIn.readLine().split("\\s+").map(_.toInt)
      val l = que(0) - 1
      val r = que(1) - 1
      val k = que(2)

      val buc = bucket(k)
      if (buc == null) {
        println(0)
      } else {
        val a = binarySearch(buc.length, a => buc(a) > r)
        val b = binarySearch(buc.length, b => buc(b) >= l)
        println(a - b)
      }

      i += 1
    }
  }
}
