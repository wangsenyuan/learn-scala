package codejam.year2009.round1c

import java.io.File

import scala.io.Source

/**
 * Created by senyuanwang on 14/11/29.
 */
object C extends App {

  def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try {
      op(p)
    } finally {
      p.close()
    }
  }

  def writeToOutput(sa: Array[String]) =
    printToFile(new File(("src/main/scala/codejam/year2009/round1c/C-large-practice.out")))(
      pw => sa.foreach(pw.write)
    )

  val file = Source.fromFile("src/main/scala/codejam/year2009/round1c/C-large-practice.in").getLines()

  val T = file.next().toInt
  val MAX = 1000000

  def play(p: Int, a: Array[Int]): Int = {
    val q = a.length
    val dp = Array.fill(q + 1, q + 2)(MAX)

    val x = Array.fill(q + 2)(0)
    x(0) = 0
    x(q + 1) = p + 1
    for (i <- 0 until q) {
      x(i + 1) = a(i)
    }

    for (i <- 0 to q) {
      dp(i)(i + 1) = 0
    }

    for {
      w <- 2 until q + 2
      i <- 0 until q + 2 - w
      j = i + w
    } {
      var t = MAX

      for {
        k <- i + 1 until j
      } {
        t = t min (dp(i)(k) + dp(k)(j))
      }
      dp(i)(j) = t + x(j) - x(i) - 2
    }
    dp(0)(q + 1)
  }

  def process(t: Int, sa: Array[String]): Unit = {
    val line = file.next().split("\\s+").map(_.toInt)
    val p = line(0)
    val q = line(1)

    val a = file.next().split("\\s+").map(_.toInt)
    val r = play(p, a)
//    writeToOutput(s"Case #$t: $r")
    sa(t - 1) = s"Case #$t: $r\n"
  }

  val rs = Array.fill(T)("")
  for {
    t <- 1 to T
  } {
    process(t, rs)
  }
  writeToOutput(rs)
}
