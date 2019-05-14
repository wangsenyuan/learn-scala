package set600.set650.p655

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}


object Solution {
  def printTree(root: TreeNode): List[List[String]] = {

    def height(node: TreeNode): Int = {
      if(node == null) {
        0
      } else {
        1 + (height(node.left) max height(node.right))
      }
    }

    def width(node: TreeNode): Int = {
      if(node == null) {
        0
      } else {
        val a = width(node.left)
        val b = width(node.right)
        (a max b) * 2 + 1
      }
    }

    val m = height(root)
    val n = width(root)
    val grid = Array.fill(m, n)("")

    def layout(node: TreeNode, r: Int, c: Int, w: Int): Unit = {
      if(node != null) {
        grid(r)(c) = s"${node.value}"
        val w2 = (w - 1) / 2
        layout(node.left, r + 1, c - (w2 + 1) / 2, w2)
        layout(node.right,r + 1, c + (w2 + 1) / 2, w2)
      }
    }

    layout(root, 0, n / 2, n)

    grid.map(_.toList).toList
  }
}
