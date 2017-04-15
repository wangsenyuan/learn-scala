package codechef.easy.ndlvote

import scala.io.StdIn

/**
  * Created by wangsenyuan on 15/04/2017.
  */
object Main {

  def readNumber(): Int = {
    var line = StdIn.readLine()
    while (line.isEmpty) {
      line = StdIn.readLine()
    }
    line.toInt
  }

  def solve(): Unit = {
    val n = readNumber()
    if (n > 0) {
      var people = 0L
      var i = 0
      while (i < n) {
        val line = StdIn.readLine().split("\\s+")

        val vote = line(0)
        var score = line(1).toLong
        if (vote == "P") {
          score -= 1
        } else {
          score += 1
        }
        score = score.abs

        if (score > people) {
          people += (score - people)
        } else if (score < people) {
          people += (people - score) & 1
        }

        i += 1
      }

      println(people)

      solve()
    }
  }

  def main(args: Array[String]): Unit = {

    solve()
  }
}
