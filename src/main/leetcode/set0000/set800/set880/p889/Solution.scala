package set0000.set800.set880.p889

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {

  def constructFromPrePost(pre: Array[Int], post: Array[Int]): TreeNode = {

    def loop(pre: Array[Int], post: Array[Int]): TreeNode = {
      if (pre.length == 0) {
        null
      } else if (pre.length == 1) {
        new TreeNode(pre(0))
      } else {
        val n = pre.length
        // pre(0) is the root and pre(0) == post(n - 1)
        val v = pre(0)
        val a = pre(1)
        var i = 0
        while (i < n - 1 && post(i) != a) {
          i += 1
        }
        // post(i) == a
        val left = loop(pre.slice(1, i + 2), post.slice(0, i + 1))
        val right = loop(pre.slice(i + 2, n), post.slice(i + 1, n - 1))
        val root = new TreeNode(v)
        root.left = left
        root.right = right
        root
      }
    }

    loop(pre, post)
  }
}
