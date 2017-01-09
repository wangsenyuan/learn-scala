package codechef.easy.knightmv

import scala.io.StdIn

/**
  * Created by wangsenyuan on 21/12/2016.
  */
object Main {

  case class Cell(h: Char, v: Int) {
    def hDiff(that: Cell) = this.h - that.h

    def vDiff(that: Cell) = this.v - that.v
  }

  private def parseAsCell(str: String): Option[Cell] = {
    if (str.length == 2) {
      if (str(0) >= 'a' && str(0) <= 'h' && str(1) >= '1' && str(1) <= '8') {
        Some(Cell(str(0), str(1) - '0'))
      } else {
        None
      }
    } else {
      None
    }
  }

  private def parse(str: String): Option[(Cell, Cell)] = {
    if (str.length == 5 && str.contains("-")) {
      val parts = str.split("-")
      if (parts.length == 2) {
        parseAsCell(parts(0)).flatMap {
          x =>
            parseAsCell(parts(1)).map {
              y => (x, y)
            }
        }
      } else {
        None
      }
    } else {
      None
    }
  }

  def checkKnightMove(str: String): String = {
    parse(str) match {
      case Some((x, y)) =>
        val h = x.hDiff(y)
        val v = x.vDiff(y)
        if (h * v == 2 || h * v == -2) {
          "Yes"
        } else {
          "No"
        }
      case None => "Error"
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1
      val line = StdIn.readLine()
      println(checkKnightMove(line))
    }
  }

}
