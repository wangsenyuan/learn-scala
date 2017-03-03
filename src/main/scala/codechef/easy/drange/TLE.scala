package codechef.easy.drange

import scala.io.StdIn

/**
  * Created by wangsenyuan on 03/03/2017.
  */
object TLE {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = firstLine(0)
        val m = firstLine(1)
        val bit = new Bit(n)

        (1 to n) foreach {
          i =>
            bit.update(i - 1, i)
            bit.update(i, -i)
        }

        (0 until m) foreach {
          _ =>
            val line = StdIn.readLine().split("\\s+").map(_.toInt)
            val w = line(0)
            val x = line(1)
            val y = line(2)
            val z = line(3)
            w match {
              case 1 =>
                bit.update(x - 1, z)
                bit.update(y, -z)
              case _ =>
                bit.update(x - 1, -z)
                bit.update(y, z)
            }
        }

        var a = Long.MaxValue
        var b = Long.MinValue
        (0 until n) foreach {
          i =>
            val x = bit.query(i)
            b = b max x
            a = a min x
        }

        println(b - a)
    }
  }

  class Bit(n: Int) {
    val tree = Array.fill(n + 1)(0L)

    def update(i: Int, v: Int): Unit = {
      var x = i + 1
      while (x <= n) {
        tree(x) += v
        x += x & -x
      }
    }

    def query(i: Int): Long = {
      var x = i + 1
      var res = 0L
      while (x > 0) {
        res += tree(x)
        x -= x & -x
      }
      res
    }
  }

}
