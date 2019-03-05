package set400.set400.p404

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def sumOfLeftLeaves(root: TreeNode): Int = {
    def go(node: TreeNode): Int = {
      if(node == null) {
        0
      } else if(node.left == null) {
        go(node.right)
      } else if(isLeaf(node.left)) {
        node.left.value + go(node.right)
      } else {
        go(node.left) + go(node.right)
      }
    }

    go(root)
  }

  private def isLeaf(node: TreeNode): Boolean = {
    node.left == null && node.right == null
  }
}
