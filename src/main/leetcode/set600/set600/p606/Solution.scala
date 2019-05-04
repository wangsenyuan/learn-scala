package set600.set600.p606

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def tree2str(t: TreeNode): String = {
    def go(node: TreeNode): String = {
      if (node == null) {
        ""
      } else if (node.left == null && node.right == null) {
        s"${node.value}"
      } else if (node.right == null) {
        s"${node.value}(${go(node.left)})"
      } else {
        s"${node.value}(${go(node.left)})(${go(node.right)})"
      }
    }

    go(t)
  }
}
