package set0000.set800.set860.p865

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def subtreeWithAllDeepest(root: TreeNode): TreeNode = {

    def visit(node: TreeNode, d: Int): (Int, TreeNode) = {
      if (node.left == null && node.right == null) {
        (d, node)
      } else if (node.left == null) {
        // then right can't be null
        visit(node.right, d + 1)
      } else if (node.right == null) {
        visit(node.left, d + 1)
      } else {
        val (a, ar) = visit(node.left, d + 1)
        val (b, br) = visit(node.right, d + 1)
        if (a == b) {
          (a, node)
        } else if (a > b) {
          (a, ar)
        } else {
          (b, br)
        }
      }
    }

    if (root == null) {
      null
    } else {
      val (_, r) = visit(root, 0)

      r
    }
  }
}
