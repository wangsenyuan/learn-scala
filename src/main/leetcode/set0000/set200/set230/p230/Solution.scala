package set0000.set200.set230.p230

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    val count = size(root.left)
    if (count >= k) {
      kthSmallest(root.left, k)
    } else if (count == k - 1) {
      root.value
    } else {
      kthSmallest(root.right, k - count - 1)
    }
  }

  private def size(root: TreeNode): Int = {
    if (root == null) {
      0
    } else {
      1 + size(root.left) + size(root.right)
    }
  }
}
