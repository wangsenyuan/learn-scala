package codejam.osmos

import scala.io.StdIn

object App extends App {

  val T = StdIn.readLine.toInt

  def process(t: Int): Unit = {
    if (t <= T) {
      val an = StdIn.readLine.split("\\s+").map(_.toInt)
      val a = an(0)
      val n = an(1)
      val xs = StdIn.readLine.split("\\s+").map(_.toInt).sorted

      def absorb(a: Int, idx: Int, cnt: Int): Int =
        if (idx >= n) cnt
        else {
          val x = xs(idx)
          if (a > x) {
            absorb(a + x, idx + 1, cnt)
          } else {
            var b = a
            var c = b - 1
            var k = 0
            val lmt = n - idx
            while (k < lmt && b <= x) {
              b = b + c
              c = b - 1
              k += 1
            }
            if (k >= lmt) {
              cnt + lmt
            } else {
              val rt = absorb(b + x, idx + 1, cnt + k)
              if (rt < cnt + lmt) {
                rt
              } else {
                cnt + lmt
              }
            }
          }
        }

      println(s"Case #$t: ${absorb(a, 0, 0)}")

      process(t + 1)
    }
  }

  process(1)
}
