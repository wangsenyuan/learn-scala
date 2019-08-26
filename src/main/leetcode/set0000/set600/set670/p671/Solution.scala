package set0000.set600.set670.p671

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def findSecondMinimumValue(root: TreeNode): Int = {

    def loop(node: TreeNode): Int = {
      if (node == null) {
        -1
      } else if (node.value > root.value) {
        node.value
      } else if (node.left == null) {
        -1
      } else {
        val a = loop(node.left)
        val b = loop(node.right)
        if (a < 0) {
          b
        } else if (b < 0) {
          a
        } else {
          a min b
        }
      }
    }

    loop(root)
  }
}
