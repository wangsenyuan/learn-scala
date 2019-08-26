package set0000.set100.set110.p112

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def hasPathSum(root: TreeNode, sum: Int): Boolean = {
    def go(node: TreeNode, res: Int): Boolean = {
      if (node == null) {
        res == sum
      } else if (node.left != null && node.right != null) {
        go(node.left, res + node.value) || go(node.right, res + node.value)
      } else if (node.left == null && node.right == null) {
        res + node.value == sum
      } else if (node.left != null) {
        go(node.left, res + node.value)
      } else {
        go(node.right, res + node.value)
      }
    }

    root != null && go(root, 0)
  }
}
