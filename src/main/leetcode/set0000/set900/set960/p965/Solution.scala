package set0000.set900.set960.p965

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isUnivalTree(root: TreeNode): Boolean = {
    val x = root.value

    def dfs(node: TreeNode): Boolean = {
      if (node == null) {
        true
      } else if (node.value != x) {
        false
      } else {
        dfs(node.left) && dfs(node.right)
      }
    }

    dfs(root)
  }
}
