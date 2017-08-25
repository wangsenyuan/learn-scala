package codechef.easy.kfunc

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }


  private def f(x: Long): Int = {
    ((x - 1) % 9).toInt + 1
  }

  private def g(p: Vector[Int], r: Long): Long = {
    val len = p.length
    var sum = 1L * p.sum
    sum *= r / len
    var i = 0
    while (i < r % len) {
      sum += p(i)
      i += 1
    }
    sum
  }

  def solve(): Unit = {
    val input = StdIn.readLine().split("\\s+").map(_.toLong)
    val a = input(0)
    val d = input(1)
    val l = input(2)
    val r = input(3)
    var vec = Vector.empty[Int]
    vec :+= f(a)

    var b = a + d
    while (f(b) != f(a)) {
      vec :+= f(b)
      b = b + d
    }

    val ans = g(vec, r) - g(vec, l - 1)

    println(ans)
  }
}
