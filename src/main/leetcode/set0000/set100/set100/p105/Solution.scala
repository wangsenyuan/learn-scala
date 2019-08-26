package set0000.set100.set100.p105

object Solution {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {

    def go(pre: Vector[Int], in: Vector[Int]): TreeNode = {
      if (pre.isEmpty) {
        null
      } else if (pre.size == 1) {
        new TreeNode(pre(0))
      } else {
        val root = new TreeNode(pre(0))
        var i = 0
        val n = in.size
        while (i < n && in(i) != pre(0)) {
          i += 1
        }
        root.left = go(pre.slice(1, i + 1), in.slice(0, i))
        root.right = go(pre.slice(i + 1, n), in.slice(i + 1, n))
        root
      }
    }

    go(preorder.toVector, inorder.toVector)
  }
}


/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}
