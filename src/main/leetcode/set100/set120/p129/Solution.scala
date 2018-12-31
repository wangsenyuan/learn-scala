package set100.set120.p129

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def sumNumbers(root: TreeNode): Int = {

    def go(node: TreeNode, num: Int): Int = {
      val cur = num * 10 + node.value
      if (node.left == null && node.right == null) {
        cur
      } else if (node.left != null && node.right != null) {
        go(node.left, cur) + go(node.right, cur)
      } else if (node.left != null) {
        go(node.left, cur)
      } else {
        go(node.right, cur)
      }
    }

    if (root == null) {
      0
    } else {
      go(root, 0)
    }
  }
}
