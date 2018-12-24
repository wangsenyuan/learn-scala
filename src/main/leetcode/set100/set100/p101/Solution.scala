package set100.set100.p101

object Solution {
  def isSymmetric(root: TreeNode): Boolean = {
    def go(left: TreeNode, right: TreeNode): Boolean = {
      if (left == null) {
        right == null
      } else if (right == null) {
        false
      } else if (left.value != right.value) {
        false
      } else {
        go(left.left, right.right) && go(left.right, right.left)
      }
    }

    if (root == null) {
      true
    } else {
      go(root.left, root.right)
    }
  }
}

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}
