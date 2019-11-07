package set1000.set1000.set1080.p1080

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def sufficientSubset(root: TreeNode, limit: Int): TreeNode = {

    def dfs(node: TreeNode, sum: Int): Int = {
      if (node.left == null && node.right == null) {
        // a leaf
        node.value + sum
      } else if (node.left == null) {
        // only right
        val r = dfs(node.right, sum + node.value)
        if (r < limit) {
          node.right = null
        }
        r
      } else if (node.right == null) {
        val r = dfs(node.left, sum + node.value)
        if (r < limit) {
          node.left = null
        }
        r
      } else {
        val x = dfs(node.left, sum + node.value)
        if (x < limit) {
          node.left = null
        }
        val y = dfs(node.right, sum + node.value)
        if (y < limit) {
          node.right = null
        }
        x max y
      }
    }

    if (root == null) {
      null
    } else {
      val r = dfs(root, 0)
      if (r < limit) {
        null
      } else {
        root
      }
    }
  }
}
