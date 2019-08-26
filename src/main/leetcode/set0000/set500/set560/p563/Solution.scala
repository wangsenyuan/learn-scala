package set0000.set500.set560.p563

/**
  * Definition for a binary tree node.
  */
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def findTilt(root: TreeNode): Int = {
    var res = 0
    def go(node: TreeNode): Int = {
      if(node == null) {
        0
      } else {
        val a = go(node.left)
        val b = go(node.right)
        res += (a - b).abs
        a + b + node.value
      }
    }

    go(root)

    res
  }
}
