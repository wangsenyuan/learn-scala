package codejam.year2008.round1a

import codejam.FileOp

/**
 * Created by senyuanwang on 15/5/21.
 */
object C extends App with FileOp {

  override val filePrefix = "src/main/scala/codejam/year2008/round1a/C-large-practice";

  type Matrix = Array[Array[Long]]
  val MOD = 1000

  def mulMatrix(a: Matrix, b: Matrix): Matrix = {
    val width = b(0).length
    val height = a.length
    val c = Array.fill(height)(Array.fill(width)(0L))

    for {
      i <- 0 until height
      k <- 0 until b.length
      j <- 0 until width
    } {
      c(i)(j) += a(i)(k) * b(k)(j) % MOD
    }
    c
  }

  def powMatrix(a: Matrix, n: Int): Matrix =
    if (n == 1) a
    else if (n % 2 == 0) {
      val b = powMatrix(a, n / 2)
      mulMatrix(b, b)
    } else {
      val b = powMatrix(a, n / 2)
      mulMatrix(a, mulMatrix(b, b))
    }

  implicit class MatrixOps(a: Matrix) {
    def mul(b: Matrix): Matrix = mulMatrix(a, b)

    def pow(n: Int): Matrix = powMatrix(a, n)
  }

  val matrixZero = Array(Array(3L, 5L), Array(1L, 3L))
  val T = file.next().toInt
  for {
    t <- 1 to T
    n = file.next().toInt
  } {
    val resultMatrix = matrixZero.pow(n)
    val result = (resultMatrix(0)(0) * 2 + 1000 - 1) % MOD
    println(f"Case #$t: $result%03d")
  }
}
