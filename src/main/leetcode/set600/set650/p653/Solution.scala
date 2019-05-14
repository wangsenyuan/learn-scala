package set600.set650.p653

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def findTarget(root: TreeNode, k: Int): Boolean = {

    def search(node: TreeNode, v: Int): Boolean = {
      if (node == null) {
        false
      } else if (node.value == v) {
        true
      } else if (node.value > v) {
        search(node.left, v)
      } else {
        search(node.right, v)
      }
    }

    def check(node: TreeNode): Boolean = {
      if (node.value * 2 >= k) {
        false
      } else {
        search(root, k - node.value)
      }
    }

    def find(node: TreeNode): Boolean = {
      if (node == null) {
        false
      } else if (check(node)) {
        true
      } else {
        find(node.left) || find(node.right)
      }
    }

    find(root)
  }
}
