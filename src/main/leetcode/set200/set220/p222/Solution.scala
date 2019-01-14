package set200.set220.p222

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def countNodes(root: TreeNode): Int = {
    if (root == null) {
      0
    } else {
      val l = left(root.left, 1)
      val r = right(root.right, 1)
      if (l == r) {
        (1 << (l)) - 1
      } else {
        1 + countNodes(root.left) + countNodes(root.right)
      }
    }
  }

  private def right(node: TreeNode, d: Int): Int = {
    if (node == null) {
      d
    } else {
      right(node.right, d + 1)
    }
  }

  private def left(node: TreeNode, d: Int): Int = {
    if (node == null) {
      d
    } else {
      left(node.left, d + 1)
    }
  }

}
