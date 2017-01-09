package codechef.easy.nocoding

import scala.io.StdIn

/**
  * Created by wangsenyuan on 12/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1

      val line = StdIn.readLine()

      val instructionCount = process(line)

      if (instructionCount <= line.length * 11) {
        println("YES")
      } else {
        println("NO")
      }

    }
  }

  def process(word: String): Int = {
    var count = 2
    for {
      i <- 1 until word.length
      cur = word(i)
      prev = word(i - 1)
    } {
      if (cur >= prev) {
        count += cur - prev
      } else {
        count += 26 - (prev - cur)
      }

      count += 1
    }

    count
  }
}
