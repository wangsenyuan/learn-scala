package codechef.easy.delish

import scala.io.StdIn

/**
  * Created by wangsenyuan on 28/02/2017.
  */
object Main {

  def calculateMaxArray(d: Array[Int], n: Int): Array[Long] = {
    val res = Array.fill(n)(0L)

    var cur = 0L
    var max = Long.MinValue
    var i = 0
    while (i < n) {
      cur += d(i)

      if (cur > max) {
        max = cur
      }
      
      res(i) = max

      if (cur < 0) {
        cur = 0
      }

      i += 1
    }

    res
  }


  def cookMoreDelicious(B: Array[Long], A: Array[Long], n: Int): Long = {
    var j = 0
    var res = Long.MinValue

    while (j < n - 1) {
      val a = A(j)
      val b = B(j + 1)
      if (b - a > res) {
        res = b - a
      }
      j += 1
    }

    res
  }

  def cookLessDelicious(B: Array[Long], A: Array[Long], n: Int): Long = {
    var j = 0
    var res = Long.MinValue
    while (j < n - 1) {
      val a = A(j)
      val b = B(j + 1)
      if (a - b > res) {
        res = a - b
      }
      j += 1
    }

    res
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        val ds = StdIn.readLine().split("\\s+").map(_.toInt)

        val A = calculateMaxArray(ds, n)
        val B = calculateMaxArray(ds.reverse, n).reverse

        val mds = ds.map(x => -x)

        val C = calculateMaxArray(mds, n).map(x => -x)
        val D = calculateMaxArray(mds.reverse, n).reverse.map(x => -x)


        val x = cookMoreDelicious(B, C, n)
        val y = cookLessDelicious(D, A, n)

        val r = x max y

        println(r)
    }
  }
}
