package set0000.set100.set110.p110

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isBalanced(root: TreeNode): Boolean = {
    def go(node: TreeNode): (Boolean, Int) = {
      if (node == null) {
        (true, 0)
      } else {
        val (ac, ah) = go(node.left)
        val (bc, bh) = go(node.right)
        if (!ac || !bc) {
          (false, -1)
        } else if ((ah - bh).abs <= 1) {
          (true, (ah max bh) + 1)
        } else {
          (false, -1)
        }
      }
    }

    val (can, _) = go(root)
    return can
  }
}
