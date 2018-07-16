package p700

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) {
      null
    } else if (root.value == `val`) {
      root
    } else if (root.value > `val`) {
      searchBST(root.left, `val`)
    } else {
      searchBST(root.right, `val`)
    }
  }
}
