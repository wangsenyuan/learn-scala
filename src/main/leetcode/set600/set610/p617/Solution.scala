package set600.set610.p617

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {
    if(t1 == null) {
      t2
    } else if(t2 == null) {
      t1
    } else {
      val t = new TreeNode(t1.value + t2.value)
      t.left = mergeTrees(t1.left, t2.left)
      t.right = mergeTrees(t1.right, t2.right)
      t
    }
  }
}
