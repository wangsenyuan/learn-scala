package codechef.easy.cubesum

import scala.io.StdIn

/**
  * Created by wangsenyuan on 29/04/2017.
  */
object Main {

  def readB(X: Int, Y: Int, Z: Int) = {
    val B = Array.fill(X, Y, Z)(0)

    var x = 0
    while (x < X) {
      var y = 0
      while (y < Y) {
        val nums = StdIn.readLine().split("\\s+").map(_.toInt)
        var z = 0
        while (z < Z) {
          B(x)(y)(z) = nums(z)
          z += 1
        }
        y += 1
      }
      x += 1
    }
    B
  }

  def getFlatNumber(B: Array[Array[Array[Int]]], x: Int, y: Int, z: Int) = {
    if (x < 0 || y < 0 || z < 0) {
      0
    } else if (z > 0) {
      B(x)(y)(z) - B(x)(y)(z - 1)
    } else {
      B(x)(y)(z)
    }
  }

  def output(A: Array[Array[Array[Int]]], X: Int, Y: Int, Z: Int) = {
    val sb = new StringBuilder
    var x = 0
    while (x < X) {
      var y = 0
      while (y < Y) {
        var z = 0
        while (z < Z) {
          sb.append(A(x)(y)(z)).append(" ")
          z += 1
        }

        sb.setLength(sb.length - 1)
        sb.append("\n")
        y += 1
      }
      x += 1
    }
    print(sb.toString())
  }

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)

    val X = line(0)
    val Y = line(1)
    val Z = line(2)

    val B = readB(X, Y, Z)

    val A = Array.fill(X, Y, Z)(0)

    var z = Z - 1
    while (z >= 0) {
      var y = Y - 1
      while (y >= 0) {
        var x = X - 1
        while (x >= 0) {
          val S0 = getFlatNumber(B, x, y, z)
          val S1 = getFlatNumber(B, x - 1, y, z)
          val S2 = getFlatNumber(B, x, y - 1, z)
          val S3 = getFlatNumber(B, x - 1, y - 1, z)

          A(x)(y)(z) = S0 + S3 - S1 - S2

          x -= 1
        }

        y -= 1
      }
      z -= 1
    }

    output(A, X, Y, Z)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
