package set500.set510.p515


/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

import scala.collection.mutable.ArrayBuffer

object Solution {
  def largestValues(root: TreeNode): List[Int] = {
    val res = ArrayBuffer.empty[Int]

    def go(root: TreeNode, depth: Int): Unit = {
      if (root != null) {
        if (res.length == depth) {
          res += root.value
        } else if (root.value > res(depth)) {
          res(depth) = root.value
        }
        go(root.left, depth + 1)
        go(root.right, depth + 1)
      }
    }

    go(root, 0)

    res.toList
  }
}
