package codechef.easy.chefbm

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/27.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val p = firstLine(2)

    val records = Array.fill[mutable.Map[Int, Int]](n)(null)
    var i = 0
    while (i < p) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val x = line(0) - 1
      val b = line(1)
      val a = b - 1
      val c = b + 1

      if (records(x) == null) {
        records(x) = mutable.Map.empty[Int, Int]
      }

      val map = records(x)
      if (!map.contains(a)) {
        map(a) = 0
      }

      if (!map.contains(c)) {
        map(c) = 0
      }

      if (!map.contains(b)) {
        map(b) = 1
      } else {
        map(b) = map(b) + 1
      }
      i += 1
    }

    i = 0
    while (i < n) {
      if (records(i) == null) {
        println(m - 1)
      } else {
        val map = records(i)
        var tmp = 0
        var j = 1
        while (j < m && tmp >= 0) {
          if (map.contains(j)) {
            val a = map(j)
            if (map.contains(j + 1)) {
              val b = map(j + 1)
              if (a + j > b + j + 1) {
                tmp = -1
              } else {
                tmp += b + 1 - a
              }
            } else {
              if (j + a > j + 1) {
                tmp = -1
              } else {
                tmp += 1 - a
              }
            }
          } else {
            // just one difference between j and j + 1
            tmp += 1
          }

          j += 1
        }

        println(tmp)
      }
      i += 1
    }

  }


}
