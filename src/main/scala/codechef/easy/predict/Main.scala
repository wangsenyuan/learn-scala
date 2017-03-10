package codechef.easy.predict

import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/03/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val pa = StdIn.readDouble()
        val pb = 1.0 - pa
        val res =
          if (2 * pa > 1) {
            10000 * (2 * pa - 1) * (1 - pa) + 10000
          } else {
            10000 * (2 * pb - 1) * (1 - pb) + 10000
          }

        println(f"$res%.6f")

    }
  }
}
