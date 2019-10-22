package set1000.set1000.set1000.p1008

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def bstFromPreorder(preorder: Array[Int]): TreeNode = {
    val n = preorder.length
    val right = Array.ofDim[Int](n)

    val stack = Array.ofDim[Int](n)
    var p = 0

    var i = n - 1
    while (i >= 0) {
      while (p > 0 && preorder(stack(p - 1)) < preorder(i)) {
        p -= 1
      }
      if (p > 0) {
        right(i) = stack(p - 1)
      } else {
        right(i) = n
      }
      stack(p) = i
      p += 1

      i -= 1
    }

    def loop(i: Int, j: Int): TreeNode = {
      if (i >= j) {
        null
      } else {
        val node = new TreeNode(preorder(i))
        val k = right(i)
        node.left = loop(i + 1, k)
        node.right = loop(k, j)
        node
      }
    }

    loop(0, n)
  }
}
