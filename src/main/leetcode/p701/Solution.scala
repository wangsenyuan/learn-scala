package p701


/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}


object Solution {
  def insertIntoBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) {
      new TreeNode(`val`)
    } else if (`val` < root._value) {
      root.left = insertIntoBST(root.left, `val`)
      root
    } else {
      root.right = insertIntoBST(root.right, `val`)
      root
    }
  }
}
