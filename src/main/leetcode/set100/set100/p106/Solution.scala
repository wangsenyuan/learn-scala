package set100.set100.p106

object Solution {
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
    def go(in: Vector[Int], post: Vector[Int]): TreeNode = {
      if (in.isEmpty) {
        null
      } else if (in.size == 1) {
        new TreeNode(in(0))
      } else {
        val n = post.size
        val root = new TreeNode(post(n - 1))
        var i = 0
        while (i < n && in(i) != post(n - 1)) {
          i += 1
        }
        root.left = go(in.slice(0, i), post.slice(0, i))
        root.right = go(in.slice(i + 1, n), post.slice(i, n - 1))
        root
      }
    }

    go(inorder.toVector, postorder.toVector)
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
