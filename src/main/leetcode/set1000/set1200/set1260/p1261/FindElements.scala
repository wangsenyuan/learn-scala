package set1000.set1200.set1260.p1261

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

class FindElements(_root: TreeNode) {

  def find(target: Int): Boolean = {
    if (target == 0) {
      true
    } else {
      val path = Array.ofDim[Int](21)
      var p = 0
      var cur = target + 1
      while (cur > 1) {
        path(p) = cur & 1
        p += 1
        cur >>= 1
      }

      var node = _root
      while (node != null && p > 0) {
        if (path(p - 1) == 1) {
          node = node.right
        } else {
          node = node.left
        }
        p -= 1
      }
      p == 0 && node != null
    }
  }

}

/**
 * Your FindElements object will be instantiated and called as such:
 * var obj = new FindElements(root)
 * var param_1 = obj.find(target)
 */
