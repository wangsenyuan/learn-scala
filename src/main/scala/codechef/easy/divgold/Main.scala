package codechef.easy.divgold

import scala.io.StdIn

/**
  * Created by wangsenyuan on 06/03/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        val s = StdIn.readLine()

        var res = s
        val sb = new StringBuilder()
        (0 until n) foreach {
          j =>
            sb.clear()
            var ok = false
            (0 until n) foreach {
              i =>
                if (i != j) {
                  if (!ok && s(i) > s(j)) {
                    sb.append(s(j))
                    ok = true
                  }
                  sb.append(s(i))
                }
            }

            if (!ok) {
              sb.append(s(j))
            }

            val str = sb.toString()
            if (str.compareTo(res) < 0) {
              res = str
            }
        }

        println(res)
    }
  }
}
