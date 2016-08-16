package codechef.pcycle

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/16/16.
  */
object Main {

  def walk(nums: Array[Int]): List[List[Int]] = {
    val n = nums.length
    val visited = Array.fill(n)(false)
    def visit(x: Int): List[Int] = {
      if (visited(x)) {
        List(x)
      } else {
        visited(x) = true
        x :: visit(nums(x))
      }
    }

    def go(i: Int): List[List[Int]] = {
      if (i == n) {
        Nil
      } else if (visited(i)) {
        go(i + 1)
      } else {
        visit(i) :: go(i + 1)
      }
    }

    go(0)
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val line = StdIn.readLine().split("\\s+").map(_.toInt - 1)
    val cycles = walk(line)
    println(cycles.size)
    cycles.foreach(l => println(l.map(_ + 1).mkString(" ")))
  }
}
