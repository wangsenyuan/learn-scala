package set500.set500.p501

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def findMode(root: TreeNode): Array[Int] = {
    if (root == null) {
      Array()
    } else {
      def go(root: TreeNode): Array[(Int, Int)] = {
        if (root == null) {
          Array()
        } else if (root.left == null && root.right == null) {
          Array(root.value -> 1)
        } else {
          val left = go(root.left)
          val right = go(root.right)
          val cnt = count(root)
          merge(merge(left, right), Array(root.value -> cnt))
        }
      }

      val res = go(root)
      res.map(_._1)
    }
  }

  private def count(root: TreeNode): Int = {
    def go(node: TreeNode): Int = {
      if (node == null) {
        0
      } else if (node.value < root.value) {
        go(node.right)
      } else if (node.value > root.value) {
        go(node.left)
      } else {
        1 + go(node.left) + go(node.right)
      }
    }

    go(root)
  }

  private def merge(a: Array[(Int, Int)], b: Array[(Int, Int)]): Array[(Int, Int)] = {
    if (a.isEmpty) {
      b
    } else if (b.isEmpty) {
      a
    } else if (a(0)._2 < b(0)._2) {
      b
    } else if (a(0)._2 > b(0)._2) {
      a
    } else {
      a ++ b
    }
  }
}
