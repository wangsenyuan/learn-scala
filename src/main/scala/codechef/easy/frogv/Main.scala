package codechef.easy.frogv

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/01/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+")
    val n = line(0).toInt
    val k = line(1).toInt
    var p = line(2).toInt

    val poss = StdIn.readLine().split("\\s+").map(_.toInt)

    val frogs = poss.zipWithIndex.sortBy(_._1).reverse

    val f = Array.fill(n)(0)
    f(frogs(0)._2) = frogs(0)._1 + k

    for {
      i <- 1 until n
    } {
      f(frogs(i)._2) =
        if (frogs(i - 1)._1 - frogs(i)._1 <= k) {
          f(frogs(i - 1)._2)
        } else {
          frogs(i)._1 + k
        }
    }

    while (p > 0) {
      val ques = StdIn.readLine().split("\\s+").map(_.toInt)
      val a = ques(0) - 1
      val b = ques(1) - 1

      if (f(a) == f(b)) {
        println("Yes")
      } else {
        println("No")
      }
      p -= 1
    }
  }
}
