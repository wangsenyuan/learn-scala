package set0000.set000.set090.p098

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}


object Solution {
  def isValidBST(root: TreeNode): Boolean = {
    def go(root: TreeNode): (Int, Int) = {
      if (root.left != null && root.right != null) {
        val (a, b) = go(root.left)
        val (c, d) = go(root.right)
        if (a <= b && b < root.value && root.value < c && c <= d) {
          (a, d)
        } else {
          (Int.MaxValue, Int.MinValue)
        }
      } else if (root.left != null) {
        val (a, b) = go(root.left)
        if (a <= b && b < root.value) {
          (a, root.value)
        } else {
          (Int.MaxValue, Int.MinValue)
        }
      } else if (root.right != null) {
        val (c, d) = go(root.right)
        if (root.value < c && c <= d) {
          (root.value, d)
        } else {
          (Int.MaxValue, Int.MinValue)
        }
      } else {
        (root.value, root.value)
      }
    }

    if (root == null) {
      true
    } else {
      val (a, b) = go(root)
      a <= b
    }
  }
}
