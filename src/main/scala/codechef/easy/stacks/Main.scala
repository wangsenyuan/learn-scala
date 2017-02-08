package codechef.easy.stacks

import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/02/2017.
  */
object Main {


  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val nums = StdIn.readLine().split("\\s+").map(_.toInt)
      val res = makeStacks(nums)
      println(s"${res.length} ${res.mkString(" ")}")
      t -= 1
    }
  }

  def makeStacks(nums: Array[Int]) = {
    var idx = 0
    var root: Node = null
    var i = 0
    while (i < nums.length) {
      if (findPos(root, nums(i))) {
        idx += 1
      }

      root = addNode(root, nums(i), idx)

      i += 1
    }

    val res = Array.fill(idx + 1)(0)

    collect(root, res)

    res
  }

  case class Node(i: Int, v: Int, left: Node, right: Node)

  def findPos(root: Node, v: Int): Boolean = {
    if (root == null) {
      false
    } else if (v < root.v) {
      true
    } else {
      findPos(root.right, v)
    }
  }

  def addNode(root: Node, v: Int, idx: Int): Node = {
    if (root == null) {
      Node(idx, v, null, null)
    } else if (v < root.v) {
      if (findPos(root.left, v)) {
        root.copy(left = addNode(root.left, v, idx))
      } else {
        root.copy(v = v)
      }
    } else {
      root.copy(right = addNode(root.right, v, idx))
    }
  }

  def collect(root: Node, res: Array[Int]): Unit = {
    if (root != null) {
      res(root.i) = root.v
      collect(root.left, res)
      collect(root.right, res)
    }
  }
}
