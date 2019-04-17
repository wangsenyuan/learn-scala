package set500.set540.p543

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def diameterOfBinaryTree(root: TreeNode): Int = {

    def loop(node: TreeNode): (Int, Int) = {
      if (node == null) {
        (0, 0)
      } else {
        val (a, x) = loop(node.left)
        val (b, y) = loop(node.right)
        // then find the node from left & right
        val u = a max b max (x + y)
        val v = (x max y) + 1
        (u, v)
      }
    }

    val (ans, _) = loop(root)
    ans
  }
}
