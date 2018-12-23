package set000.set090.p094

import scala.collection.mutable.ListBuffer

object Solution {

  def inorderTraversal(root: TreeNode): List[Int] = {
    val buf = ListBuffer.empty[Int]
    var node = root
    while (node != null) {
      if (node.left == null) {
        buf += node.value
        node = node.right
      } else {
        //need to go left
        var tmp = node.left
        while (tmp.right != null && tmp.right != node) {
          tmp = tmp.right
        }
        // tmp is the right-most child of node-left
        if (tmp.right == null) {
          tmp.right = node
          node = node.left
        } else {
          buf += node.value
          tmp.right = null
          node = node.right
        }
      }
    }

    buf.toList
  }

  def inorderTraversal1(root: TreeNode): List[Int] = {
    val buf = ListBuffer.empty[Int]

    def go(root: TreeNode): Unit = {
      if (root != null) {
        go(root.left)
        buf += root.value
        go(root.right)
      }
    }

    go(root)

    buf.toList
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
