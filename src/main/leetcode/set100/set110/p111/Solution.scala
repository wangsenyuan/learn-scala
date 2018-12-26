package set100.set110.p111

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def minDepth(root: TreeNode): Int = {

    def go(node: TreeNode, res: Int): Int = {
      if (node == null) {
        res - 1
      } else if (node.left != null && node.right != null) {
        go(node.left, res + 1) min go(node.right, res + 1)
      } else if (node.left == null && node.right == null) {
        res
      } else if (node.left != null) {
        go(node.left, res + 1)
      } else {
        go(node.right, res + 1)
      }
    }

    go(root, 1)
  }
}
