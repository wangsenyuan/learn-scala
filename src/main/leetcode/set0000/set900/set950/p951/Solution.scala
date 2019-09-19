package set0000.set900.set950.p951

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def flipEquiv(root1: TreeNode, root2: TreeNode): Boolean = {
    if (root1 == null && root2 == null) {
      true
    } else if (root1 == null || root2 == null) {
      false
    } else if (root1.value != root2.value) {
      false
    } else {
      (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (
        flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
        )
    }
  }
}
