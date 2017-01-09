package codechef.easy.anudtc

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1
      val n = StdIn.readInt()

      val res = Array(checkDivideEqually(n), checkCanDivideNPieces(n), checkDivideUnEqually(n))

      val yn = res.map(r => if (r) "y" else "n")

      println(yn.mkString(" "))
    }
  }

  def checkDivideEqually(n: Int): Boolean = {
    360 % n == 0
  }

  def checkCanDivideNPieces(n: Int): Boolean = {
    n <= 360
  }

  def checkDivideUnEqually(n: Int): Boolean = {
    (n + 1) * n / 2 <= 360
  }
}
