package codechef.easy.csumd

import scala.io.StdIn

/**
  * Created by wangsenyuan on 03/03/2017.
  */
object Main {

  val MOD = 1000000007

  def main(args: Array[String]): Unit = {

    val t = StdIn.readInt()

    val grid = Array(Array(2L, 2L, 0L), Array(1L, 0L, 0L), Array(0L, 1L, 0L))
    val mt = new Matrix(grid, 3)
    val ft = new Matrix(Array(Array(3L, 0L, 0L), Array(1L, 0L, 0L), Array(1L, 0L, 0L)), 3)

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()

        if (n == 1) {
          println(1)
        } else if (n == 2) {
          println(3)
        } else {
          val A = mt.pow(n - 2)
          val B = A.mul(ft)
          println(B(0, 0))
        }

    }
  }

  class Matrix(val grid: Array[Array[Long]], val n: Int) {

    def apply(i: Int, j: Int) = grid(i)(j)

    def mul(that: Matrix): Matrix = {
      val result = Array.fill(n, n)(0L)

      (0 until n) foreach {
        i =>
          (0 until n) foreach {
            j =>
              (0 until n) foreach {
                k =>
                  result(i)(k) += (this (i, j) * that(j, k)) % MOD
                  result(i)(k) %= MOD
              }
          }
      }

      new Matrix(result, n)
    }

    def pow(n: Int): Matrix = {
      if (n == 1) {
        this
      } else {
        val x = pow(n / 2)
        val y = x mul x
        if (n % 2 == 1) {
          y mul this
        } else {
          y
        }
      }
    }
  }

}
