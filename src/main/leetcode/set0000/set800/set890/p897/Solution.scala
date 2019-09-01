package set0000.set800.set890.p897

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def increasingBST(root: TreeNode): TreeNode = {
    def loop(node: TreeNode): TreeNode = {
      if (node == null) {
        null
      } else if (node.left == null) {
        val newRoot = new TreeNode(node.value)
        newRoot.right = loop(node.right)
        newRoot
      } else {
        val newRoot = loop(node.left)
        var tmp = newRoot
        while (tmp.right != null) {
          tmp = tmp.right
        }
        tmp.right = new TreeNode(node.value)
        tmp = tmp.right
        tmp.right = loop(node.right)
        newRoot
      }
    }

    loop(root)
  }
}
