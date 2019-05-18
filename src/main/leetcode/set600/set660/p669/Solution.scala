package set600.set660.p669

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def trimBST(root: TreeNode, L: Int, R: Int): TreeNode = {

    def trim(node: TreeNode): TreeNode = {
      if(node == null) {
        null
      } else if(node.value < L) {
        trim(node.right)
      } else if(node.value > R) {
        trim(node.left)
      } else {
        val res = new TreeNode(node.value)
        res.left = trim(node.left)
        res.right = trim(node.right)
        res
      }
    }

    trim(root)
  }
}
