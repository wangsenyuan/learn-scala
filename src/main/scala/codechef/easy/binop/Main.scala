package codechef.easy.binop

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/6.
  */
object Main {

  def solve() = {
    val a = StdIn.readLine()
    val b = StdIn.readLine()

    if (a.forall(_ == '0')) {
      println("Unlucky Chef")
    } else if (a.forall(_ == '1')) {
      println("Unlucky Chef")
    } else {
      val c = a.zip(b)
      val cnt0 = c.count(x => x._1 != x._2 && x._1 == '0')
      val cnt1 = c.count(x => x._1 != x._2 && x._1 == '1')
      val res = cnt0 max cnt1
      println("Lucky Chef")
      println(res)
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()

      i += 1
    }
  }
}
