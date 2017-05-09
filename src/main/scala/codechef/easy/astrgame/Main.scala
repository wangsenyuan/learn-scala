package codechef.easy.astrgame

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/05/2017.
  */
object Main {

  def createWordIndex(src: String, dict: Array[String]): Array[Vector[Int]] = {
    val n = src.length
    val idx = Array.fill(n)(Vector.empty[Int])

    var i = 0
    while (i < dict.length) {
      val word = dict(i)

      var j = 0
      while (j < src.length) {
        val k = src.indexOf(word, j)
        if (k < 0) {
          j = src.length
        } else {
          idx(k) :+= word.length
          j = k + word.length
        }
      }

      i += 1
    }

    idx
  }

  def mex(grundy: mutable.Set[Int]): Int = {
    var i = 0
    while (grundy.contains(i)) {
      i += 1
    }
    i
  }

  def solve() = {
    val src = StdIn.readLine()
    val n = StdIn.readInt()
    val dict = Array.fill(n)("")

    var i = 0
    while (i < n) {
      dict(i) = StdIn.readLine()
      i += 1
    }

    val wordIdx = createWordIndex(src, dict)

    val len = src.length
    val cache = Array.fill(len, len + 1)(-1)

    def check(start: Int, end: Int): Int = {
      if (cache(start)(end) == -1) {
        var canMove = false
        var i = start
        val grundy = mutable.Set.empty[Int]
        while (i < end) {
          val words = wordIdx(i)

          if (words.size > 0) {
            canMove = true

            var j = 0
            while (j < words.length) {
              val wordLen = words(j)
              val wordEnd = i + wordLen

              if (i == start && wordEnd < end) {
                grundy += check(wordEnd, end)
              }

              if (i > start && wordEnd == end) {
                grundy += check(start, i)
              }

              if (i > start && wordEnd < end) {
                grundy += (check(start, i) ^ check(wordEnd, end))
              }

              if (i == start && wordEnd == end) {
                grundy += 0
              }

              j += 1
            }
          }
          i += 1
        }

        val res =
          if (!canMove) {
            0
          } else {
            mex(grundy)
          }
        cache(start)(end) = res
        res
      } else {
        cache(start)(end)
      }
    }

    val res = check(0, len)

    if (res > 0) {
      println("Teddy")
    } else {
      println("Tracy")
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
