package codejam.year2017.test.c

import codejam.FileOp

import scala.annotation.tailrec
import scala.util.Random

/**
  * Created by senyuanwang on 2016/10/18.
  */
object Large2 extends App with FileOp {
  override val filePrefix: String = "src/main/scala/codejam/year2017/test/c/console-practice"

  val T = file.next().toInt
  var t = 1
  var res = Vector.empty[String]
  while (t <= T) {
    val line = file.next().split("\\s+")
    val n = line(0).toInt
    val x = line(1).toLong
    val k = line(2).toLong
    val a = line(3).toInt
    val b = line(4).toInt
    val c = line(5).toInt

    val r = rng(n, x, k, a, b, c)

    res :+= f"Case #$t: ${r}%.10f\n"

    t += 1
  }

  writeToOutput(res)

  def rng(n: Int, x: Long, k: Long, a: Int, b: Int, c: Int): Double = {
    val rand = new Random(41)

    def sample(n: Int, x: Long): Long = {
      if (n == 0) {
        x
      } else {
        val d = rand.nextInt(100)
        if (d < a) {
          sample(n - 1, x & k)
        } else if (d >= a + b) {
          sample(n - 1, x ^ k)
        } else {
          sample(n - 1, x | k)
        }
      }
    }

    val times = 1000000

    val sum = (0 until times).map(_ => sample(n, x)).sum
    1.0d * sum / times
  }
}
