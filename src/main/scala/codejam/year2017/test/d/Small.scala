package codejam.year2017.test.d

import codejam.FileOp

/**
  * Created by wangsenyuan on 18/10/2016.
  */
object Small extends App with FileOp {

  override val filePrefix = "src/main/scala/codejam/year2017/test/d/console-practice"

  var res = Vector.empty[String]
  val T = file.next().toInt

  var t = 1
  while (t <= T) {
    val line1 = file.next().split("\\s+")
    val q = line1(1).toInt
    val nums = file.next().split("\\s+").map(_.toInt)

    val bob = new Bob(nums)
    res :+= f"Case #$t: \n"
    println(f"Case #$t: \n")
    var i = 0
    while (i < q) {
      val line2 = file.next().split("\\s+").map(_.toInt)
      val r = bob.ask(line2(0) - 1, line2(1))
      res :+= f"$r\n"
      println(f"$r\n")
      i += 1
    }

    t += 1
  }

  writeToOutput(res)

  class Bob(nums: Array[Int]) {
    private val n = nums.length
    private val m = n * (n + 1) / 2
    private val xs = fillXs()

    private def fillXs(): Array[Int] = {
      val xs = Array.fill(m)(0)
      var p = 0

      def fill(step: Int, start: Int): Unit =
        if (step < n) {
          val end = start + n - step
          var i = start
          while (i < end) {
            val a = i - (n - step + 1)
            val b = a + 1
            xs(p) = xs(a) + xs(b)
            val c = a - (n - step + 2) + 1
            if (c > 0) {
              xs(p) -= xs(c)
            }
            p += 1
            i += 1
          }
          fill(step + 1, start + n - step)
        }

      var i = 0
      while (i < n) {
        xs(p) = nums(i)
        p += 1
        i += 1
      }

      fill(1, n)

      xs.sorted
    }

    val sums = Array.fill(m + 1)(0L)

    var i = 0
    while (i < m) {
      sums(i + 1) = xs(i) + sums(i)
      i += 1
    }


    def ask(l: Int, r: Int): Long = {
      sums(r) - sums(l)
    }
  }

}
