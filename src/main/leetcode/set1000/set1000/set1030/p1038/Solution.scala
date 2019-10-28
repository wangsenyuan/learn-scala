package set1000.set1000.set1030.p1038


object Solution {

  /**
   * Definition for a binary tree node.
   **/
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }


  def bstToGst(root: TreeNode): TreeNode = {

    def dfs(node: TreeNode, sum: Int): (Int, TreeNode) = {
      if (node == null) {
        (0, null)
      } else {
        val (rs, rr) = dfs(node.right, sum)
        val (ls, ll) = dfs(node.left, sum + rs + node.value)
        val newNode = new TreeNode(sum + rs + node.value)
        newNode.left = ll
        newNode.right = rr
        val s = rs + ls + node.value
        (s, newNode)
      }
    }

    val (_, newRoot) = dfs(root, 0)
    newRoot
  }
}
