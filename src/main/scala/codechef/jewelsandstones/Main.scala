package codechef.jewelsandstones

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/15/16.
  */
object Main {

  def fillArrayWith(s: String) = {
    val array = Array.fill(52)(0)
    for {
      c <- s
    } {
      val x =
        if (c >= 'a' && c <= 'z') {
          c - 'a'
        } else {
          c - 'A' + 26
        }
      array(x) += 1
    }
    array
  }

  def play(a: String, b: String): Int = {
    val ac = fillArrayWith(a)
    val bc = fillArrayWith(b)
    var c = 0
    for {
      i <- 0 until 52
      c1 = ac(i)
      c2 = bc(i)
      if c1 > 0
    } {
      c += c2
    }
    c
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val a = StdIn.readLine()
      val b = StdIn.readLine()
      val r = play(a, b)
      println(r)
      t -= 1
    }
  }
}
