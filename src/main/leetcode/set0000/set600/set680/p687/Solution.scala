package set0000.set600.set680.p687

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def longestUnivaluePath(root: TreeNode): Int = {
    def loop(node: TreeNode): Int = {
      if(node == null) {
        0
      } else {
        val a = loop(node.left)
        val b = loop(node.right)
        val x = findSame(node.left, node.value)
        val y = findSame(node.right, node.value)
        a max b max (x + y - 1)
      }
    }

    loop(root)
  }
  private def findSame(node: TreeNode, v: Int): Int = {
    if(node == null || node.value != v) {
      0
    } else  {
      1 + (findSame(node.left, v) max findSame(node.right, v))
    }
  }
}
