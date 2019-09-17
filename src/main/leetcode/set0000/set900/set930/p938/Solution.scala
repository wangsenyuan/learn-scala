package set0000.set900.set930.p938

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def rangeSumBST(root: TreeNode, L: Int, R: Int): Int = {

    def loop(node: TreeNode): Int = {
      if (node == null) {
        0
      } else if (node.value > R) {
        loop(node.left)
      } else if (node.value < L) {
        loop(node.right)
      } else {
        node.value + loop(node.left) + loop(node.right)
      }
    }

    loop(root)

  }
}
