package codechef.easy.tourmap

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 27/03/2017.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val A = Array.fill(n - 1)("")
    val B = Array.fill(n - 1)("")
    val C = Array.fill(n - 1)(0)


    val as = mutable.Set[String]()
    val bs = mutable.Set[String]()
    val idx = mutable.Map[String, Int]()

    var totalCost = 0
    var i = 0
    while (i < n - 1) {
      val line = StdIn.readLine().split("\\s+")
      val src = line(0)
      val dst = line(1)
      val mny = line(2).init.toInt
      A(i) = src
      as += src
      idx(src) = i
      B(i) = dst
      bs += dst
      C(i) = mny
      totalCost += mny

      i += 1
    }

    var src = (as -- bs).head

    while (idx.contains(src)) {
      val i = idx(src)
      val a = A(i)
      val b = B(i)
      val c = C(i)
      println(s"$a $b $c$$")
      src = b
    }

    println(s"$totalCost$$")
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
