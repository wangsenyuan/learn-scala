package set1000.set1300.set1340.p1343

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  val MOD = 1000000007

  def maxProduct(root: TreeNode): Int = {
    val s = sum(root)

    var res = 0L

    def dfs(node: TreeNode): Long = {
      if (node == null) {
        0
      } else {
        val a = node.value + dfs(node.left) + dfs(node.right)
        val b = s - a
        res = res max (a * b)
        a
      }
    }

    dfs(root)

    (res % MOD).toInt
  }

  private def sum(root: TreeNode): Long = {
    if (root == null) {
      0
    } else {
      root.value + sum(root.left) + sum(root.right)
    }
  }
}
