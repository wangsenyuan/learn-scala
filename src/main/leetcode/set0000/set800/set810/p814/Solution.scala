package set0000.set800.set810.p814

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def pruneTree(root: TreeNode): TreeNode = {

    def prune(node: TreeNode): TreeNode = {
      if (node == null) {
        null
      } else {
        val res = new TreeNode(node.value)
        res.left = prune(node.left)
        res.right = prune(node.right)
        if (res.value == 1 || res.left != null || res.right != null) {
          res
        } else {
          null
        }
      }
    }

    prune(root)
  }
}
