package codechef.pptest

import scala.io.StdIn

/**
  * Created by wangsenyuan on 03/01/2017.
  */
object Main {

  case class Question(value: Int, cost: Int)

  def getBestPoints(questions: Array[Question], w: Int, n: Int): Int = {
    val dp = Array.fill(w + 1)(0)

    for {
      i <- 0 until n
      q = questions(i)
      x <- w to q.cost by -1
    } {
      dp(x) = dp(x) max (dp(x - q.cost) + q.value)
    }

    dp(w)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val w = line(1)

      val questions = Array.fill[Question](n)(null)

      var i = 0
      while (i < n) {
        val qline = StdIn.readLine().split("\\s+").map(_.toInt)
        questions(i) = Question(qline(0) * qline(1), qline(2))
        i += 1
      }

      val res = getBestPoints(questions, w, n)

      println(res)

      t -= 1
    }
  }
}
