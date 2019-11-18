package set1000.set1100.set1120.p1123

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def lcaDeepestLeaves(root: TreeNode): TreeNode = {

    if (root == null) {
      null
    } else {
      val maxDepth = getDepth(root)

      val count = countMaxDepth(root, maxDepth)

      var ans: TreeNode = null

      def dfs(node: TreeNode, h: Int): Int = {
        val cnt = if (node == null) {
          0
        } else if (h == maxDepth) {
          1
        } else {
          dfs(node.left, h + 1) + dfs(node.right, h + 1)
        }
        if (cnt == count && ans == null) {
          ans = node
        }
        cnt
      }

      dfs(root, 1)

      ans
    }
  }

  private def getDepth(node: TreeNode): Int = {
    if (node == null) {
      0
    } else {
      1 + (getDepth(node.left) max getDepth(node.right))
    }
  }

  private def countMaxDepth(root: TreeNode, maxDepth: Int): Int = {
    def loop(node: TreeNode, h: Int): Int = {
      if (node == null) {
        0
      } else if (h == maxDepth) {
        1
      } else {
        loop(node.left, h + 1) + loop(node.right, h + 1)
      }
    }

    loop(root, 1)
  }
}
