package set500.set530.p530

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  val INF = 1 << 20

  def getMinimumDifference(root: TreeNode): Int = {
    def go(node: TreeNode): Int = {
      if (node == null) {
        INF
      } else if (node.left == null && node.right == null) {
        INF
      } else {
        var res = INF
        if (node.left != null) {
          res = res min go(node.left)
          val leftMax = findMax(node.left)
          res = res min (node.value - leftMax.value)
        }

        if (node.right != null) {
          res = res min go(node.right)
          val rightMin = findMin(node.right)
          res = res min (rightMin.value - node.value)
        }

        res
      }
    }

    go(root)
  }

  private def findMax(node: TreeNode): TreeNode = {
    if (node.right == null) {
      node
    } else {
      findMax(node.right)
    }
  }

  private def findMin(node: TreeNode): TreeNode = {
    if (node.left == null) {
      node
    } else {
      findMin(node.left)
    }
  }
}
