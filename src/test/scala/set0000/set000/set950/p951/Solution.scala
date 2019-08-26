package set0000.set000.set950.p951

object Solution {

  def flipEquiv(root1: TreeNode, root2: TreeNode): Boolean = {
    if (root1 == null && root2 == null) {
      true
    } else if (root1 == null || root2 == null || root1.value != root2.value) {
      false
    } else {
      (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
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
