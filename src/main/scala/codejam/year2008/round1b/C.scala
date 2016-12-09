package codejam.year2008.round1b

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/12/2016.
  */
object C {

  def main(args: Array[String]): Unit = {

    val T = StdIn.readInt()

    var t = 1
    while (t <= T) {
      val k = StdIn.readInt()
      val line = StdIn.readLine().split("\\s+").map(_.toInt)

      val ds = line.tail

      val deck = perfectDeck(k)

      val vals = ds.map(d => deck(d - 1))

      println(s"Case #$t: ${vals.mkString(" ")}")

      t += 1
    }

  }

  def perfectDeck(k: Int): Array[Int] = {
    val deck = Array.fill(k)(0)

    def skip(cnt: Int, i: Int): Int = {
      if (deck(i % k) > 0) {
        skip(cnt, i + 1)
      } else if (cnt == 0) {
        i
      } else {
        skip(cnt - 1, i + 1)
      }
    }

    def fill(from: Int, i: Int): Unit =
      if (i <= k) {
        val j = skip(i - 1, from) % k
        deck(j) = i
        fill((j + 1) % k, i + 1)
      }

    fill(0, 1)

    deck
  }
}
