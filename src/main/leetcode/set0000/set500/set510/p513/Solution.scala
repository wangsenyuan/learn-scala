package set0000.set500.set510.p513

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def findBottomLeftValue(root: TreeNode): Int = {
    var res = root.value
    var d = 0
    def go(node: TreeNode, depth: Int): Unit = {
      if(node != null) {
        if(depth > d) {
          res = node.value
          d = depth
        }
        go(node.left, depth + 1)
        go(node.right, depth + 1)
      }
    }
    go(root, 0)
    res
  }
}
