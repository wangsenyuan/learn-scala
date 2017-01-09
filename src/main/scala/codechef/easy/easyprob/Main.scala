package codechef.easy.easyprob

import scala.annotation.tailrec

/**
  * Created by wangsenyuan on 15/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    println(output(137))
    println(output(1315))
    println(output(73))
    println(output(136))
    println(output(255))
    println(output(1384))
    println(output(16385))
  }

  def output(num: Int): String = {
    s"$num=${expr(num)}"
  }

  private def expr(num: Int): String = {
    log(num).map {
      case 0 => "2(0)"
      case 1 => "2"
      case x => "2(" + expr(x) + ")"
    }.mkString("+")
  }

  private def log(num: Int): Vector[Int] = {
    @tailrec
    def cal(x: Int, y: Int, num: Int): (Int, Int) = {
      if (2 * y > num) {
        (x, y)
      } else {
        cal(x + 1, 2 * y, num)
      }
    }

    var res = Vector.empty[Int]
    var n = num
    while (n > 0) {
      val (x, y) = cal(0, 1, n)
      res :+= x
      n = n - y
    }

    res
  }
}
