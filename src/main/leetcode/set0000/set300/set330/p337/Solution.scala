package set0000.set300.set330.p337

object Solution {

  /**
    * Definition for a binary tree node.
    **/
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def rob(root: TreeNode): Int = {
    if (root == null) {
      0
    } else {
      def go(node: TreeNode): (Int, Int) = {
        if (node == null) {
          (0, 0)
        } else {
          val (a, b) = go(node.left)
          val (c, d) = go(node.right)
          ((b + d + node.value) max (a + c), a + c)
        }
      }

      val (a, _) = go(root)
      a
    }
  }
}
