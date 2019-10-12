package set0000.set900.set970.p979

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def distributeCoins(root: TreeNode): Int = {

    var res = 0

    /**
     * distribute coins underneath node, return the coins needed ( > 0 ) or left ( < 0)
     *
     * @param node
     * @return
     */
    def dfs(node: TreeNode): Int = {
      if (node == null) {
        0
      } else {
        val a = dfs(node.left)
        res += a.abs
        val b = dfs(node.right)
        res += b.abs

        a + b + 1 - node.value
      }
    }

    dfs(root)

    res
  }
}
