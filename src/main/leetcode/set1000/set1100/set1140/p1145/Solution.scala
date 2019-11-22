package set1000.set1100.set1140.p1145

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def btreeGameWinningMove(root: TreeNode, n: Int, x: Int): Boolean = {

    def findNode(node: TreeNode): TreeNode = {
      if (node == null) {
        null
      } else if (node.value == x) {
        node
      } else {
        val a = findNode(node.left)
        if (a != null) {
          a
        } else {
          findNode(node.right)
        }
      }
    }

    val xNode = findNode(root)

    def count(node: TreeNode): Int = {
      if (node == null) {
        0
      } else {
        count(node.left) + count(node.right) + 1
      }
    }

    val a = count(xNode.left)
    val b = count(xNode.right)
    val c = n - a - b - 1

    val h = n / 2

    a > h || b > h || c > h
  }
}
