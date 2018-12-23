package set000.set090.p099


object Solution {

  def recoverTree(root: TreeNode): Unit = {
    var first: TreeNode = null
    var second: TreeNode = null
    var prev: TreeNode = null

    def findSwap(root: TreeNode): Unit = {
      if (prev != null && prev.value > root.value) {
        if (first == null) {
          first = prev
        }
        second = root
      }
    }

    def go(root: TreeNode): Unit = {
      if (root.left != null) {
        go(root.left)
      }

      findSwap(root)
      prev = root

      if (root.right != null) {
        go(root.right)
      }
    }

    if (root != null) {
      go(root)
    }

    if (first != null && second != null) {
      swap(first, second)
    }
  }

  private def swap(a: TreeNode, b: TreeNode) = {
    val tmp = a.value
    a.value = b.value
    b.value = tmp
  }
}


class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}
