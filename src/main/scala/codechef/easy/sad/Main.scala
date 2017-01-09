package codechef.easy.sad

import scala.io.StdIn

/**
  * Created by wangsenyuan on 05/01/2017.
  */
object Main {

  def findGift(matrix: Array[Array[Long]], r: Int, c: Int): Option[Long] = {

    def checkCol(j: Int, max: Long): Boolean = {
      (0 until r).forall(matrix(_)(j) <= max)
    }

    def findRow(i: Int): Option[Long] = {
      if (i == r) {
        None
      } else {
        val min = matrix(i).min
        ((0 until c).filter(matrix(i)(_) == min).find {
          j => checkCol(j, min)
        }).map(_ => min).orElse(findRow(i + 1))
      }
    }

    findRow(0)
  }

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val r = line(0)
    val c = line(1)

    val matrix = Array.fill(r, c)(-1L)

    var i = 0
    while (i < r) {
      val nums = StdIn.readLine().split("\\s+").map(_.toLong)
      var j = 0
      while (j < c) {
        matrix(i)(j) = nums(j)
        j += 1
      }
      i += 1
    }

    val res = findGift(matrix, r, c)

    res match {
      case None => println("GUESS")
      case Some(x) => println(x)
    }
  }
}
