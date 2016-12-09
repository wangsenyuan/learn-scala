package codejam.year2008.round1b

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/12/2016.
  */
object LargeC {

  def main(args: Array[String]): Unit = {

    val T = StdIn.readInt()

    var t = 1
    while (t <= T) {
      val k = StdIn.readInt()
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val queries = line.tail
      val answers = Array.fill(n)(-1)

      var pos = 0
      for {
        i <- 1 to k
      } {
        pos = (pos + i - 1) % (k - i + 1)
        for {
          j <- 0 until n
          if answers(j) < 0
        } {
          if (queries(j) == pos + 1) {
            queries(j) = -1
            answers(j) = i
          } else if (queries(j) > pos + 1) {
            queries(j) -= 1
          }
        }
      }


      println(s"Case #$t: ${answers.mkString(" ")}")

      t += 1
    }

  }
}
