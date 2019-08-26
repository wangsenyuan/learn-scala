package set0000.set100.set110.p114

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def flatten(root: TreeNode): Unit = {
    var node = root

    while (node != null) {
      if (node.left != null) {
        var tmp = node.left
        while (tmp.right != null && tmp.right != node) {
          tmp = tmp.right
        }

        if (tmp.right == null) {
          tmp.right = node
          node = node.left
        } else {
          tmp.right = node.right
          node.right = node.left
          node.left = null
          node = tmp.right
        }
      } else {
        node = node.right
      }
    }
  }
}
