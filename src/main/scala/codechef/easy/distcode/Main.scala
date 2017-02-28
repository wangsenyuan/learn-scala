package codechef.easy.distcode

import scala.io.StdIn

/**
  * Created by wangsenyuan on 28/02/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine()
        var codes = Set.empty[String]
        line.zip(line.tail) foreach {
          z =>
            val (a, b) = z
            codes += "" + a + b
        }

        println(codes.size)
    }
  }
}
