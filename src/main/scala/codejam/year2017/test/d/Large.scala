package codejam.year2017.test.d

import codejam.FileOp

/**
  * Created by wangsenyuan on 18/10/2016.
  */
object Large extends App with FileOp {

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
      val line2 = file.next().split("\\s+").map(_.toLong)
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
    val MAX_M = 20000002
    val m = 1L * n * (n + 1) / 2
    val number = Array.fill(MAX_M)(0)
    var maxS = 0

    for {
      i <- 0 until n
    } {
      var s = 0
      for {
        j <- i to 0 by -1
      } {
        s += nums(i)
        number(s) += 1
        if (s > maxS) {
          maxS = s
        }
      }
    }


    def ask(l: Long, r: Long): Long = {
      var left = l
      var right = m - r

      var i = 1
      var j = maxS

      while (number(i) <= left) {
        left -= number(i)
        i += 1
      }

      while (number(j) >= right) {
        right -= number(j)
        j -= 1
      }
      var ans = (number(i) - left) * i

      for {
        x <- i + 1 until j
      } {
        ans += number(x) * x
      }

      if (i == j) {
        ans
      } else {
        ans + (number(j) - right) * j
      }
    }
  }

}
