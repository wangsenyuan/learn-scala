package codechef.easy.sumq

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/6/28.
  */
object Main {

  val MOD = 1000000007

  def main(args: Array[String]): Unit = {
    val t = StdIn.readLine().trim.toInt

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val p = firstLine(0)
    val q = firstLine(1)
    val r = firstLine(2)

    val A = StdIn.readLine().split("\\s+").map(_.toLong).sorted
    val B = StdIn.readLine().split("\\s+").map(_.toLong).sorted
    val C = StdIn.readLine().split("\\s+").map(_.toLong).sorted

    var ans = 0L

    var nx = 0
    var nz = 0
    var sx = 0L
    var sz = 0L
    var i = 0
    while (i < q) {
      val Y = B(i)

      var j = nx
      while (j < p && Y >= A(j)) {
        sx += A(j)
        j += 1
        nx += 1
      }

      var k = nz
      while (k < r && Y >= C(k)) {
        sz += C(k)
        k += 1
        nz += 1
      }

      val m1 = (sx + j * Y) % MOD
      val m2 = (sz + k * Y) % MOD

      ans = (ans + m1 * m2) % MOD

      i += 1
    }

    println(ans)
  }
}
