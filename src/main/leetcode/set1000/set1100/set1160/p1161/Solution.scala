package set1000.set1100.set1160.p1161

import scala.collection.mutable.ArrayBuffer

/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def maxLevelSum(root: TreeNode): Int = {
    val buf = ArrayBuffer.empty[Int]

    def visit(node: TreeNode, level: Int): Unit = {
      if (node != null) {
        if (buf.length <= level) {
          buf += node.value
        } else {
          buf(level) += node.value
        }
        visit(node.left, level + 1)
        visit(node.right, level + 1)
      }
    }

    visit(root, 0)
    1 + buf.zipWithIndex.maxBy(_._1)._2
  }
}
