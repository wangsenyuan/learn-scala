package set200.set240.p241

import scala.collection.mutable

object Solution {
  def diffWaysToCompute(input: String): List[Int] = {
    val n = input.length

    val mem = mutable.Map.empty[String, List[Int]]

    def go(start: Int, end: Int): List[Int] = {
      val key = input.substring(start, end + 1)
      if (mem.contains(key)) {
        mem(key)
      } else {
        if (key.forall(Character.isDigit)) {
          val num = key.toInt
          mem(key) = List(num)
        } else {
          var res = List.empty[Int]
          for {
            i <- start to end
            if (!Character.isDigit(input(i)))
          } {
            val a = go(start, i - 1)
            val b = go(i + 1, end)
            res ++= merge(a, b, input(i))
          }
          mem(key) = res
        }

        mem(key)
      }
    }

    go(0, input.length - 1)
  }

  private def merge(a: List[Int], b: List[Int], c: Char): List[Int] = {
    for {
      x <- a
      y <- b
    } yield cal(x, y, c)
  }

  private def cal(a: Int, b: Int, c: Char): Int = {
    c match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case _ => 0
    }
  }
}
