package codechef.easy.emitl

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/03/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    val org = "EMITL"
    val spe = "LTIMEMITL".sorted
    (0 until t) foreach {
      _ =>
        val str = StdIn.readLine()
        val cnt = Array.fill(26)(0)
        str foreach {
          x =>
            cnt(x - 'A') += 1
        }
        val ans = org.forall(x => cnt(x - 'A') > 1)
        if (ans) {
          println("YES")
        } else {
          if (str.sorted.equals(spe)) {
            println("YES")
          } else {
            println("NO")
          }
        }
    }
  }
}
