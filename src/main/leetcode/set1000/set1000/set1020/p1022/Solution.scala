package set1000.set1000.set1020.p1022

/**
 * Definition for a binary tree node.
 */
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def sumRootToLeaf(root: TreeNode): Int = {

    def loop(node: TreeNode, res: Int): Int = {
      val ans = (res << 1) + node.value
      if (node.left == null && node.right == null) {
        ans
      } else if (node.left == null) {
        loop(node.right, ans)
      } else if (node.right == null) {
        loop(node.left, ans)
      } else {
        loop(node.left, ans) + loop(node.right, ans)
      }
    }

    if (root == null) {
      0
    } else {
      loop(root, 0)
    }
  }
}
