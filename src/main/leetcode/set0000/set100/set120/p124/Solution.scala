package set0000.set100.set120.p124

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def maxPathSum(root: TreeNode): Int = {
    def go(node: TreeNode): (Int, Int) = {
      if (node == null) {
        (Int.MinValue, Int.MinValue)
      } else {
        val (la, lb) = go(node.left)
        val (ra, rb) = go(node.right)
        val a = (la max ra max 0) + node.value
        val b = lb max rb max ((la max 0) + (ra max 0) + node.value)
        (a, b)
      }
    }

    val (_, res) = go(root)
    res
  }
}

