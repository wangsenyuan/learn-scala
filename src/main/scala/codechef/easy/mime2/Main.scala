package codechef.easy.mime2

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/2.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    var n = firstLine(0)
    var q = firstLine(1)

    var table = Map.empty[String, String]

    while (n > 0) {
      val line = StdIn.readLine().split("\\s+")
      table += line(0) -> line(1)
      n -= 1
    }

    while (q > 0) {
      val line = StdIn.readLine().split("\\.")

      if (line.length <= 1) {
        println("unknown")
      } else table.get(line(line.length - 1)) match {
        case Some(v) => println(v)
        case None => println("unknown")
      }

      q -= 1
    }
  }
}
