package codejam.year2009.round2

import scala.io.Source

/**
 * Created by senyuanwang on 14/11/23.
 */
object A extends App {

  val file = Source.fromFile("src/main/scala/codejam/year2009/round2/A-large-practice.in").getLines()
  val T = file.next().toInt

  def calPos(xs: Array[Int]): Int = {
    var pos = xs.length - 1;

    while(pos >= 0 && xs(pos) == 0) {
      pos -= 1
    }

    pos
  }

  def findNearstPos(xs: Array[Int], i: Int) = {
    var j = i
    while(j < xs.length && xs(j) > i) {
      j += 1
    }
    j
  }

  def process(t: Int): Unit = {
    val n = file.next().toInt

    val matrix = Array.fill(n, n)(0)

    for {
      i <- 0 until n
      line = file.next().toCharArray().map(_ - '0')
      j <- 0 until n
    } {
      matrix(i)(j) = line(j)
    }

    val posArray = Array.fill(n)(-1)

    for {
      i <- 0 until n
    } {
      posArray(i) = calPos(matrix(i))
    }

    var ans = 0

    for {
      i <- 0 until n
    } {
      val j = findNearstPos(posArray, i)
      var k = j
      val x = posArray(k)
      while(k > i) {
        posArray(k) = posArray(k - 1)
        k -= 1
      }
      posArray(i) = x
      ans += j - i
    }

    println(s"Case #$t: $ans")
  }

  for {
    i <- 1 to T
  } {
    process(i)
  }
}
