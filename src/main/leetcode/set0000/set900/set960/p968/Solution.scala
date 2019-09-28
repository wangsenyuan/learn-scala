package set0000.set900.set960.p968

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def minCameraCover(root: TreeNode): Int = {

    val INF = 1 << 20

    def loop(node: TreeNode): Array[Int] = {
      // res[0] = put a camera at node
      // res[1] = no camera at node but node is covered by children
      // res[2] = no camera at node, but node is not covered
      if (node == null) {
        Array(INF, 0, 0)
      } else {
        val a = loop(node.left)
        val b = loop(node.right)

        val res = Array.ofDim[Int](3)
        val x = a(0) min a(1)
        val y = b(0) min b(1)

        res(0) = 1 + (x min a(2)) + (y min b(2))
        res(1) = (x + b(0)) min (y + a(0))
        res(2) = a(1) + b(1)
        res
      }
    }

    val res = loop(root)

    res(0) min res(1)
  }
}
