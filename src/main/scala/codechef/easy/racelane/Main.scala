package codechef.easy.racelane

import java.util

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val lanes = (0 until 10).map(_ => new util.TreeMap[Int, Int]()).toArray

    val n = StdIn.readInt()
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val s = line(0)
      val e = line(1)
      val j = line(2)
      lanes(j).put(s, e)
      i += 1
    }

    var ans = 500
    var x = 1
    while (x <= 500) {
      var j = 1
      var missing = false
      while (j < 10 && !missing) {
        val a = lanes(j - 1).floorEntry(x)
        if (a != null) {
          val ae = a.getValue
          if (ae >= x) {
            val b = lanes(j).floorEntry(x)
            if (b != null) {
              val be = b.getValue
              if (be >= x) {
                missing = true
              }
            }
          }
        }

        if (missing) {
          ans -= 1
        }

        j += 1
      }
      x += 1
    }

    println(ans)
  }
}
