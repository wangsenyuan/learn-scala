package set0000.set900.set990.p998

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def insertIntoMaxTree(root: TreeNode, v: Int): TreeNode = {
    if (root == null) {
      new TreeNode(v)
    } else if (root.value < v) {
      val newRoot = new TreeNode(v)
      newRoot.left = root
      newRoot
    } else {
      // v can only go right
      root.right = insertIntoMaxTree(root.right, v)
      root
    }
  }
}
