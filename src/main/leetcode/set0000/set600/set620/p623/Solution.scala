package set0000.set600.set620.p623

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def addOneRow(root: TreeNode, v: Int, d: Int): TreeNode = {

    def insert(node: TreeNode, depth: Int): TreeNode = {
      if(node == null) {
        null
      } else if(depth == d - 1) {
        val newNode = new TreeNode(node.value)
        newNode.left = new TreeNode(v)
        newNode.left.left = node.left
        newNode.right = new TreeNode(v)
        newNode.right.right = node.right
        newNode
      } else {
        val newNode = new TreeNode(node.value)
        newNode.left = insert(node.left, depth +1)
        newNode.right = insert(node.right, depth + 1)
        newNode
      }
    }

    if(d > 1) {
      insert(root, 1)
    } else {
      val newRoot = new TreeNode(v)
      newRoot.left = root
      newRoot
    }

  }
}
