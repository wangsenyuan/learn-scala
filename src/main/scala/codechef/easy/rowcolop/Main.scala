package codechef.easy.rowcolop

import scala.io.StdIn

/**
  * Created by wangsenyuan on 15/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    var q = firstLine(1)
    val rows = Array.fill(n)(0L)
    val cols = Array.fill(n)(0L)
    while (q > 0) {
      q -= 1

      val line = StdIn.readLine().split("\\s+")
      val i = line(1).toInt
      val x = line(2).toInt
      line(0) match {
        case "RowAdd" =>
          rows(i - 1) += x
        case "ColAdd" =>
          cols(i - 1) += x

      }
    }
    println(rows.max + cols.max)
  }
}
