package codejam.year2004.wf

import scala.io.Source

/**
 * Created by senyuanwang on 14/11/16.
 */
object B extends App {

  val file = Source.fromFile("src/main/scala/codejam/year2004/wf/B-large-practice.in").getLines()
  val T = file.next().toInt

  private def isSorted(array: Array[Int]): Boolean = {
    var sorted = true

    var i = 1
    while (sorted && i < array.length) {
      val x = array(i - 1)
      val y = array(i)
      sorted = y > x
      i = i + 1
    }

    sorted
  }

  private def swap(array: Array[Int], n: Int, i: Int, j: Int): Unit = {
    for {
      k <- 0 until n
    } {
      val x = array(i + k)
      array(i + k) = array(j + k)
      array(j + k) = x
    }
  }

  def play(array: Array[Int], n: Int, k: Int, count: Int): Long = {
    if (k == n) {
      count.factorial
    } else {
      var xs: List[Int] = Nil
      var i = 0
      val sz = (2 ** k).toInt
      while (i < 2 ** n) {
        if (array(i) + sz != array(i + sz)) {
          xs = i :: xs
        }
        i = i + sz * 2
      }

      xs match {
        case Nil => play(array, n, k + 1, count)
        case i :: Nil =>
          swap(array, sz, i, i + sz)
          val ret =
            if (array(i) + sz == array(i + sz)) {
              play(array, n, k + 1, count + 1)
            } else 0L
          swap(array, sz, i, i + sz)
          ret
        case j :: i :: Nil =>
          var ret = 0L
          for {
            x <- i :: (i + sz) :: Nil
            y <- j :: (j + sz) :: Nil

          } {
            swap(array, sz, x, y)
            if(array(i) + sz == array(i + sz) && array(j) + sz == array(j + sz)) {
              ret += play(array, n, k + 1, count + 1)
            }
            swap(array, sz, x, y)
          }

          ret
        case _ => 0L
      }
    }
  }

  def process(t: Int): Unit =
    if (t <= T) {
      val n = file.next().toInt
      //      val p = Math.pow(2, n).toInt
      val array = file.next().split("\\s+").map(_.toInt)

      val result = play(array, n, 0, 0)

      println(s"Case #$t: $result")

      process(t + 1)
    }

  process(1)

  implicit class NumberWithPow(x: Long) {
    def **(y: Long) = Math.pow(x, y).toLong

    def factorial: Long = {
      def go(n: Long): Long = if(n > 0) n * go(n - 1) else 1
      go(x)
    }
  }


/*  println(1.factorial)

  println(3.factorial)

  println(5.factorial)*/
}
