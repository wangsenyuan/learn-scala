package codechef.easy.sprnmbrs

import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/03/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(BigInt(_))
        val l = line(0)
        val r = line(1)

        var x = BigInt(2)
        var ans = 0L

        while (x <= r) {
          var y = x

          while (y <= r) {
            if (y >= l) {
              ans += 1
            }
            y *= 3
          }


          x *= 2
        }

        if (l <= 1 && 1 <= r) {
          ans += 1
        }

        println(ans)
    }
  }
}
