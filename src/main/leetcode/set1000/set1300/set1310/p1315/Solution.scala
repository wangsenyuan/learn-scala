package set1000.set1300.set1310.p1315

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def sumEvenGrandparent(root: TreeNode): Int = {
    var sum = 0

    def loop(node: TreeNode): Unit = {
      if (node != null) {
        if (node.value % 2 == 0) {
          if (node.left != null) {
            sum += getValue(node.left.left) + getValue(node.left.right)
          }

          if (node.right != null) {
            sum += getValue(node.right.left) + getValue(node.right.right)
          }
        }
        loop(node.left)
        loop(node.right)
      }
    }

    loop(root)

    sum
  }

  private def getValue(node: TreeNode): Int = {
    if (node == null) {
      0
    } else {
      node.value
    }
  }
}
