package codechef.easy.approx

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/12/2016.
  */
object Main {


  def main(args: Array[String]): Unit = {

    val solver = new Solver(103993, 33102)

    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val k = StdIn.readLong()
      println(solver.approx(k))
    }
  }

  class Solver(A: Int, B: Int) {

    private def init(): Vector[Int] = {
      val rem = Array.fill(B)(-1)

      @tailrec
      def go(i: Int, x: Int, vec: Vector[Int]): Vector[Int] = {
        if (rem(x) >= 0) {
          vec
        } else {
          rem(x) = i
          go(i + 1, x * 10 % B, vec :+ (x * 10 / B))
        }
      }

      go(0, (A % B * 10) % B, Vector())
    }

    val seq = init()

    val n = seq.size

    def approx(k: Long): String = {
      if (k == 0) {
        "3"
      } else if (k == 1) {
        "3.1"
      } else {
        val a = ((k - 1) / n).toInt
        val b = ((k - 1) % n).toInt
        val str = seq.mkString("")
        "3.1" + (str * a) + (str.take(b))
      }
    }
  }

}
