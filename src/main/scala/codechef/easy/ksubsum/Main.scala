package codechef.easy.ksubsum

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    (0 until t) foreach {
      _ => solve()
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k1 = firstLine(1)
    val k2 = firstLine(2)
    val k3 = firstLine(3)

    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    def merge(a: Vector[Int], b: Vector[Int]): Vector[Int] = {
      val buf = ListBuffer.empty[Int]

      var i = 0
      var j = 0
      while (i < a.size || j < b.size) {
        if (i == a.size || (j < b.size && a(i) < b(j))) {
          buf += b(j)
          j += 1
        } else {
          buf += a(i)
          i += 1
        }
      }

      buf.toVector
    }

    def insertAndSort(vec: Vector[Int], num: Int): Vector[Int] = {
      val buf = ListBuffer.empty[Int]

      var i = 0
      while (i < vec.size && vec(i) < num) {
        buf += vec(i)
        i += 1
      }
      buf += num

      while (i < vec.size) {
        buf += vec(i)
        i += 1
      }
      buf.toVector
    }

    @tailrec
    def process(i: Int, sum: Int, minPrevSums: Vector[Int], best: Vector[Int]): Vector[Int] = {
      if (i == n) {
        best
      } else {
        val newSum = sum + nums(i)

        val cur = minPrevSums.map(newSum - _)
        val newBest = merge(best, cur).take(k3)
        val newMinPrevSums = insertAndSort(minPrevSums, newSum).take(k3)
        process(i + 1, newSum, newMinPrevSums, newBest)
      }
    }

    val topK = process(0, 0, Vector(0), Vector.empty)

    val a = topK(k1 - 1)
    val b = topK(k2 - 1)
    val c = topK(k3 - 1)

    println(s"$a $b $c")
  }
}
