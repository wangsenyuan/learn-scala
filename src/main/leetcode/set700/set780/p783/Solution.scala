package set700.set780.p783

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def minDiffInBST(root: TreeNode): Int = {

    def loop(node: TreeNode): (Int, TreeNode, TreeNode) = {
      if (node == null) {
        (Int.MaxValue, null, null)
      } else {
        val (a, b, c) = loop(node.left)
        val (x, y, z) = loop(node.right)
        var ans = a min x
        if (c != null) {
          ans = ans min (node.value - c.value)
        }
        if (y != null) {
          ans = ans min (y.value - node.value)
        }
        var left = b
        if (left == null) {
          left = node
        }
        var right = z
        if (right == null) {
          right = node
        }

        (ans, left, right)
      }
    }

    loop(root)._1
  }
}
