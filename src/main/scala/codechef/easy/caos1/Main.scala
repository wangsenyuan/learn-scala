package codechef.easy.caos1

import scala.io.StdIn

/**
  * Created by wangsenyuan on 02/03/2017.
  */
object Main {

  def countCPC(grid: Array[String], r: Int, c: Int) = {
    var res = 0
    (2 until r - 2) foreach {
      i =>
        (2 until c - 2) foreach {
          j =>
            if (grid(i)(j) == '^') {
              var cnt = 0
              (-2 to 2) foreach {
                x =>
                  if (grid(i + x)(j) == '^') {
                    cnt += 1
                  }

                  if (grid(i)(j + x) == '^') {
                    cnt += 1
                  }
              }

              if (cnt == 10) {
                res += 1
              }
            }
        }
    }

    res
  }

  def main(args: Array[String]): Unit = {

    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        val r = line(0)
        val c = line(1)

        val grid = Array.fill(r)("")
        (0 until r) foreach {
          i =>
            grid(i) = StdIn.readLine()
        }

        val res = countCPC(grid, r, c)

        println(res)
    }

  }
}
