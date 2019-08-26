package set0000.set100.set190.p199

import scala.collection.mutable.ListBuffer

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def rightSideView(root: TreeNode): List[Int] = {
    val res = ListBuffer.empty[Int]

    def go(root: TreeNode, gate: Int, level: Int): Int = {
      if (root != null) {
        if (level > gate) {
          res += root.value
        }

        val right = go(root.right, gate, level + 1)
        val left = go(root.left, right, level + 1)
        left max right
      } else {
        (level - 1) max gate
      }
    }

    go(root, -1, 0)
    res.toList
  }
}
