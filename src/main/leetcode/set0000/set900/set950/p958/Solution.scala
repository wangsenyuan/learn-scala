package set0000.set900.set950.p958

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isCompleteTree(root: TreeNode): Boolean = {
    if (root == null) {
      true
    } else {
      if (!isCompleteTree(root.left) || !isCompleteTree(root.right)) {
        false
      } else {
        // a and b are both complete
        val x = findLeftHeight(root.left)
        val y = findRightHeight(root.left)
        val u = findLeftHeight(root.right)
        val v = findRightHeight(root.right)
        if (x == y + 1) {
          y == u && u == v
        } else if (u == v + 1) {
          x == y && y == u
        } else if (y == u + 1) {
          x == y && u == v
        } else {
          x == y && y == u && u == v
        }
      }
    }
  }

  private def findLeftHeight(root: TreeNode): Int = {
    var res = 0
    var node = root
    while (node != null) {
      res += 1
      node = node.left
    }
    res
  }

  private def findRightHeight(root: TreeNode): Int = {
    var res = 0
    var node = root
    while (node != null) {
      res += 1
      node = node.right
    }
    res
  }
}
