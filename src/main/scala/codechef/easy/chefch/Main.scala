package codechef.easy.chefch

import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/01/2017.
  */
object Main {

  def makeChain(str: String): Int = {

    def countDiff(a: String, b: String) = a.zip(b).count(x => x._1 != x._2)

    val n = str.length

    if (n % 2 == 0) {
      countDiff("+-" * (n / 2), str) min countDiff("-+" * (n / 2), str)
    } else {
      countDiff(("+-" * (n / 2)) + "+", str) min countDiff(("-+" * (n / 2)) + "-", str)
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine()
      val res = makeChain(line)
      println(res)
      t -= 1
    }
  }
}
