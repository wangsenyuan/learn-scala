package codechef.easy.playfit

import scala.io.StdIn

/**
  * Created by wangsenyuan on 15/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1
      val n = StdIn.readInt()
      val scores = StdIn.readLine().split("\\s+").map(_.toInt)

      if (scores.length < 2) {
        println("UNFIT")
      } else {
        val maxDiff = check(scores)
        if (maxDiff == 0) {
          println("UNFIT")
        } else {
          println(maxDiff)
        }
      }
    }
  }

  def check(scores: Array[Int]): Int = {
    def go(minScore: Int, maxDiff: Int, i: Int): Int = {
      if (i == scores.length) {
        maxDiff
      } else if (scores(i) > minScore) {
        go(minScore, maxDiff max (scores(i) - minScore), i + 1)
      } else {
        go(scores(i), maxDiff, i + 1)
      }
    }

    go(scores(0), 0, 1)
  }
}
