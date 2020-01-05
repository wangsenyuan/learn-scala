package set1000.set1300.set1300.p1302

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def deepestLeavesSum(root: TreeNode): Int = {
    val maxDepth = getDepth(root)
    var res = 0

    def dfs(node: TreeNode, h: Int): Unit = {
      if (node != null) {
        if (h == maxDepth) {
          res += node.value
        } else {
          dfs(node.left, h + 1)
          dfs(node.right, h + 1)
        }
      }
    }

    dfs(root, 1)

    res
  }

  private def getDepth(node: TreeNode): Int = {
    if (node == null) {
      0
    } else {
      (getDepth(node.right) max getDepth(node.left)) + 1
    }
  }
}
