package set0000.set500.set570.p572

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isSubtree(s: TreeNode, t: TreeNode): Boolean = {
    if (t == null) {
      true
    } else if (s == null) {
      false
    } else {
      sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t)
    }
  }

  private def sameTree(a: TreeNode, b: TreeNode): Boolean = {
    if (a == null) {
      b == null
    } else if (b == null) {
      false
    } else {
      a.value == b.value && sameTree(a.left, b.left) && sameTree(a.right, b.right)
    }
  }
}
