package set0000.set900.set990.p993

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
    def getDepth(node: TreeNode, h: Int, x: Int): Int = {
      if (node == null) {
        -1
      } else if (node.value == x) {
        h
      } else {
        val a = getDepth(node.left, h + 1, x)
        if (a >= 0) {
          a
        } else {
          getDepth(node.right, h + 1, x)
        }
      }
    }

    def sameParent(node: TreeNode): Boolean = {
      if (node == null) {
        false
      } else {
        val res = node.left != null && node.right != null && ((node.left.value == x && node.right.value == y) || (node.right.value == x && node.left.value
          == y))

        res || sameParent(node.left) || sameParent(node.right)
      }
    }

    val xh = getDepth(root, 0, x)
    val yh = getDepth(root, 0, y)
    if (xh != yh) {
      false
    } else {
      !sameParent(root)
    }
  }
}
