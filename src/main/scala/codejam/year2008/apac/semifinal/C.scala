package codejam.year2008.apac.semifinal

import codejam.FileOp

/**
 * Created by senyuanwang on 14/11/29.
 */
object C extends App with FileOp {
  override val filePrefix = "src/main/scala/codejam/year2008/apac/semifinal/C-large-practice";

  val T = file.next().toInt

  def process(t: Int, sa: Array[String]): Unit = {
    val line = file.next().split("\\s+")
    val m = line(0).toInt
    val p = line(1).toDouble
    val x = line(2).toLong

    val n = 1 << m

    val dp = Array.fill(2, n + 1)(0.0)

    dp(0)(n) = 1.0
    var k = 0
    for {
      r <- 0 until m
    } {
      for {
        i <- 0 to n
        jup = i min n - i
      } {
        dp((k + 1) % 2)(i) = (0 to jup).foldLeft(0.0)((z, j) => z max (p * dp(k)(i + j) + (1 - p) * dp(k)(i - j)))
      }

      k = (k + 1) % 2
    }

    val i = (x * n / 1000000).toInt

    sa(t - 1) = f"Case #$t: ${dp(k)(i)}%.6f\n"

  }

  val sa = Array.fill(T)("")

  for {
    i <- 1 to T
  } {
    process(i, sa)
  }

  writeToOutput(sa)
}
