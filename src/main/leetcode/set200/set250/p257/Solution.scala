package set200.set250.p257

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def binaryTreePaths(root: TreeNode): List[String] = {
    def go(root: TreeNode, res: String): List[String] = {
      if (root.left == null && root.right == null) {
        List(res)
      } else if (root.left != null && root.right != null) {
        go(root.left, res + s"->${root.left.value}") ++ go(root.right, res + s"->${root.right.value}")
      } else if (root.left != null) {
        go(root.left, res + s"->${root.left.value}")
      } else {
        go(root.right, res + s"->${root.right.value}")
      }
    }

    if (root == null) {
      Nil
    } else {
      go(root, s"${root.value}")
    }
  }
}
