package codejam.year2017.test.c

import codejam.FileOp

/**
  * Created by wangsenyuan on 13/10/2016.
  */
object Small extends App with FileOp {
  override val filePrefix: String = "src/main/scala/codejam/year2017/test/c/C-large-practice"

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

    val r = rng(n, x, k, a / 100.0d, b / 100.0d, c / 100.0d)

    res :+= f"Case #$t: ${r}%.10f\n"

    t += 1
  }

  writeToOutput(res)

  def rng(n: Int, x: Long, k: Long, a: Double, b: Double, c: Double): Double = {
    def go(n: Int, x: Long, e: Double): Seq[(Long, Double)] = {
      if (n == 0) {
        Vector((x, e))
      } else {
        val sub = go(n - 1, x & k, a) ++ go(n - 1, x | k, b) ++ go(n - 1, x ^ k, c)
        sub.groupBy(_._1).mapValues(_.map(_._2).sum * e).toVector
      }
    }
    go(n, x, 1.0).map(x => x._1 * x._2).sum
  }
}
