package codechef.easy.chcube

import scala.io.StdIn

/**
  * Created by wangsenyuan on 27/02/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    //front, back, left, right, top and bottom
    val trip = Array(
      (0, 2, 4),
      (0, 3, 4),
      (0, 2, 5),
      (0, 3, 5),
      (1, 2, 4),
      (1, 3, 4),
      (1, 2, 5),
      (1, 3, 5)
    )

    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+")
        val res = trip.foldLeft(false) {
          (res, x) =>
            val (a, b, c) = x
            res || line(a) == line(b) && line(b) == line(c)
        }
        if (res) {
          println("YES")
        } else {
          println("NO")
        }
    }
  }
}
