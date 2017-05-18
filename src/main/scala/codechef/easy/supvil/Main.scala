package codechef.easy.supvil

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/05/2017.
  */
object Main {

  def solve() = {
    val n = StdIn.readLine().trim.toInt
    var balance = 0
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().trim
      if (balance < 2 && balance > -3) {
        val l = line.length
        if (l >= 3 && line(l - 3) == 'm' && line(l - 2) == 'a' && line(l - 1) == 'n') {
          balance += 1
        } else {
          balance -= 1
        }
      }

      i += 1
    }

    if (balance == 2) {
      println("superheroes")
    } else if (balance == -3) {
      println("villains")
    } else {
      println("draw")
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readLine().trim.toInt

    (0 until t) foreach {
      _ => solve()
    }
  }
}
