package problems.simple.p081

import java.util.Scanner

object App extends App {

  val scanner = new Scanner(System.in)

  val n = scanner.nextInt()
  val k = scanner.nextInt()

  val as = Array.fill(n)(0)
  val bs = Array.fill(n)(0)

  for {
    i <- 0 until n
  } {
    as(i) = scanner.nextInt()
    bs(i) = scanner.nextInt()
  }

  case class Node(r: Int, ts: Set[Int], index: Int)

  def fill(nodes: List[Node], r: Int, ts: Set[Int]): List[Node] = {
    val head = nodes.head
    if (r > head.r) {
      Node(r, ts, head.index + 1) :: nodes
    } else if (r == head.r) {
      Node(r, ts, head.index) :: nodes
    } else {
      val list = fill(nodes.tail, r, ts)
      val nHead = list.head
      if (nHead.r == head.r) {
        head.copy(index = nHead.index) :: list
      } else {
        head.copy(index = nHead.index + 1) :: list
      }
    }
  }

  def arrange(nodes: List[Node], i: Int, t: Int): List[Node] = {
    if (i == 0 && nodes.head.index >= k) nodes
    else {
      val a = as(i)
      val b = bs(i)
      val r = a + b * t
      val newNodes = fill(nodes, r, Set(t))
      if (i < n - 1) {
        arrange(newNodes, i + 1, t)
      } else {
        arrange(newNodes, 0, t + 1)
      }
    }
  }

  def compact(nodes: List[Node]): List[Node] = {
    val maxR = nodes.head.r
    def add(nodes: List[Node], result: List[Node]): List[Node] =
      nodes match {
        case List(x) if (x.index == 0) => result
        case head :: tail =>
          var newResult = result
          for {
            node <- tail
            if (node.index > 0 && head.ts.intersect(node.ts).size == 0 && head.r + node.r < maxR)
          } {
            newResult = fill(newResult, head.r + node.r, head.ts ++ node.ts)
          }

          add(tail, newResult)
      }

    val indexA = nodes.head.index

    val result = add(nodes, nodes)

    val indexB = result.head.index

    if (indexA == indexB) {
      nodes
    } else {
      compact(result.dropWhile(_.index > k))
    }
  }

  val nodes = arrange(List(Node(0, Set(), 0)), 0, 1).dropWhile(_.index > k)

  val result = compact(nodes).dropWhile(_.index > k).head

  println(result.r)
}
