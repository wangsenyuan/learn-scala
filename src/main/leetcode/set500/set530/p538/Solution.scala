package set500.set530.p538

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def convertBST(root: TreeNode): TreeNode = {
    // get the sum of the root
    def go(node: TreeNode, delta: Int): (TreeNode, Int) = {
      if (node == null) {
        (null, 0)
      } else {
        val (right, a) = go(node.right, delta)
        val (left, b) = go(node.left, a + node.value + delta)
        val newNode = new TreeNode(node.value + a + delta)
        newNode.right = right
        newNode.left = left
        (newNode, a + b + node.value)
      }
    }

    val (res, _) = go(root, 0)
    res
  }
}
