package codejam.year2016.qualification.problemb

import scala.io.StdIn

/**
  * Created by wangsenyuan on 4/27/16.
  */
object Main extends App {

  def flipPancake(sides: Array[Char]): Int = {

    def changeExpect(current: Char): Char = if (current == '+') '-' else '+'

    def doFlip(i: Int, flips: Int, expect: Char): Int = {
      if (i < 0) {
        return flips;
      }

      if (expect == sides(i)) {
        doFlip(i - 1, flips, expect)
      } else {
        doFlip(i - 1, flips + 1, changeExpect(expect))
      }
    }

    doFlip(sides.length - 1, 0, '+')
  }

  val T = StdIn.readLine().toInt

  for (i <- 1 to T) {
    val line = StdIn.readLine()
    val y = flipPancake(line.toCharArray)
    println(s"Case #$i: $y")
  }
}
