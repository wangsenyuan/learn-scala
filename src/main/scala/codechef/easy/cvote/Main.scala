package codechef.easy.cvote

import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/02/2017.
  */
object Main {


  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)

    var mapping = Map.empty[String, String]
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+")
      mapping += line(0) -> line(1)
      i += 1
    }

    var votes = Map.empty[String, Int]
    var ctys = Map.empty[String, Int]
    var x = 0
    var y = 0
    i = 0
    while (i < m) {
      val line = StdIn.readLine()
      val cty = mapping(line)
      votes += line -> (1 + votes.getOrElse(line, 0))
      if (votes(line) > x) {
        x = votes(line)
      }

      ctys += cty -> (1 + ctys.getOrElse(cty, 0))

      if (ctys(cty) > y) {
        y = ctys(cty)
      }

      i += 1
    }

    val win = votes.filter(_._2 == x).map(_._1).min
    val cty = ctys.filter(_._2 == y).map(_._1).min

    println(cty)
    println(win)
  }
}
