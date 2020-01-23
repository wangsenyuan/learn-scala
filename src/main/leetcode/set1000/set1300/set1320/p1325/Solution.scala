package set1000.set1300.set1320.p1325

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def removeLeafNodes(root: TreeNode, target: Int): TreeNode = {

    def dfs(node: TreeNode): TreeNode = {
      if (node == null) {
        null
      } else {
        val left = dfs(node.left)
        val right = dfs(node.right)
        if (node.value != target || left != null || right != null) {
          val newNode = new TreeNode(node.value)
          newNode.left = left
          newNode.right = right
          newNode
        } else {
          null
        }
      }
    }

    dfs(root)
  }
}
