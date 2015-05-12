package problems.simple.p037

import java.util.Scanner

/**
 * Created by senyuanwang on 15/4/29.
 */
object App extends App {

  val console = new Scanner(System.in)
  val n = console.nextInt()
  val nums = new Array[Int](n)

  for {
    i <- 0 until n
    x = console.nextInt()
  } {
    nums(i) = x
  }

  var forest = Node(Int.MaxValue, Nil)

  for {
    x <- nums
  } {
    forest = forest.add(x)
  }

  val paths = forest.result("")

  val (len, cnt) =
    ((0, 0) /: paths) {
      (res, path) =>
        val (len, cnt) = res
        val parts = path.split(">")
        if (parts.length > len) {
          (parts.length, 1)
        } else if (parts.length == len) {
          (len, cnt + 1)
        } else {
          res
        }
    }

  println(s"${len - 2} $cnt")
}


case class Node(value: Int, children: List[Node]) {
  def add(value: Int): Node = {
    if (value >= this.value) this //no change
    else Node(this.value, Node(value, Nil) :: children.map(_.add(value)))
  }

  def result(path: String): Set[String] = {
    children match {
      case Nil => Set(path + ">" + value)
      case list =>
        (Set.empty[String] /: list) {
          (res, child) =>
            res ++ child.result(path + ">" + value)
        }
    }
  }
}