package codechef.easy.wcount

import scala.io.StdIn

/**
  * Created by wangsenyuan on 15/02/2017.
  */
object Main {

  val M: Long = 1000000007

  val primes = Array(2, 3, 5, 7)

  def countAnagrams(word: String): Long = {
    val n = word.length

    def normalize(n: Int, i: Int, count: Array[Int]): Unit = {
      var x = n
      while (x > 0 && x % primes(i) == 0) {
        x /= primes(i)
        count(i) += 1
      }
    }

    val gs = word.groupBy(identity).map(_._2.size).toList

    val count = Array.fill(4)(0)

    gs foreach {
      v =>
        (1 to v) foreach {
          w =>
            (0 until 4).foreach {
              i =>
                normalize(w, i, count)
            }
        }
    }

    val nums = (1 to n).toArray

    (0 until 4) foreach {
      i =>
        (0 until n) foreach {
          j =>
            while (count(i) > 0 && nums(j) % primes(i) == 0) {
              nums(j) /= primes(i)
              count(i) -= 1
            }
        }
    }

    nums.foldLeft(1L) {
      (ans, num) =>
        (ans * num) % M
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine()
      val res = countAnagrams(line)

      println(res)

      t -= 1
    }
  }
}
