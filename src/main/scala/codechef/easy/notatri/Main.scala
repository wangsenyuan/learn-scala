package codechef.easy.notatri

import scala.io.StdIn

/**
  * Created by senyuanwang on 2016/12/13.
  */
object Main {

  def main(args: Array[String]): Unit = {
    process(StdIn.readInt())
  }

  def process(n: Int): Unit = {
    if (n > 0) {
      val sticks = StdIn.readLine().split("\\s+").map(_.toInt)
      val res = choose(sticks)
      println(res)
      process(StdIn.readInt())
    }
  }

  def choose(sticks: Array[Int]): Int = {
    val sorted = sticks.sorted
    var res = 0
    var i = sorted.length - 1
    while (i > 1) {
      var j = 0
      var k = i - 1
      while (j < k) {
        if (sorted(j) + sorted(k) < sorted(i)) {
          res += k - j
          j += 1
        } else {
          k -= 1
        }
      }

      i -= 1
    }

    res
  }

}
