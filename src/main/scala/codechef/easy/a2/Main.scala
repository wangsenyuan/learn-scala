package codechef.easy.a2

import scala.io.StdIn

/**
  * Created by wangsenyuan on 02/03/2017.
  */
object Main {


  def verify(leaves: Array[Int], k: Int) = {
    var i = 0
    var stem = 1
    while (i < k && stem > 0) {
      stem = 2 * (stem - leaves(i))
      i += 1
    }

    i == k && stem == 0
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()


    (0 until t) foreach {
      _ =>
        val k = StdIn.readInt()
        val leaves = StdIn.readLine().split("\\s+").map(_.toInt)
        val res = verify(leaves, k)
        if (res) {
          println("Yes")
        } else {
          println("No")
        }
    }
  }
}
