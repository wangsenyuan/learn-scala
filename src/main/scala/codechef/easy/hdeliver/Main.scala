package codechef.easy.hdeliver

import scala.io.StdIn

/**
 * Created by wangsenyuan on 27/02/2017.
 */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = firstLine(0)
        val m = firstLine(1)

        val uf = new UF(n)

        (0 until m) foreach {
          _ =>
            val line = StdIn.readLine().split("\\s+").map(_.toInt)
            uf.union(line(0), line(1))
        }
        val q = StdIn.readInt()

        (0 until q) foreach {
          _ =>
            val line = StdIn.readLine().split("\\s+").map(_.toInt)
            val a = line(0)
            val b = line(1)
            if (uf.find(a) == uf.find(b)) {
              println("YO")
            } else {
              println("NO")
            }
        }
    }
  }

  class UF(n: Int) {
    val parent = (0 until n).toArray
    val mass = Array.fill(n)(1)

    def find(x: Int): Int = {
      val p = parent(x)

      if (p != x) {
        parent(x) = find(p)
      }

      parent(x)
    }

    def union(a: Int, b: Int): Boolean = {
      val x = find(a)
      val y = find(b)

      if (x == y) {
        false
      } else {
        if (mass(x) > mass(y)) {
          parent(y) = x
          mass(x) += mass(y)
        } else {
          parent(x) = y
          mass(y) += mass(x)
        }
        true
      }
    }
  }

}
