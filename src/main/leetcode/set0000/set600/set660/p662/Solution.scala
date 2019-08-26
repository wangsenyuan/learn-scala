package set0000.set600.set660.p662

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
  def widthOfBinaryTree(root: TreeNode): Int = {
    val left = ArrayBuffer.empty[Int]

    def visit(node: TreeNode, h: Int, index: Int): Int = {
      if (node == null) {
        0
      } else {
        if (left.size == h) {
          left += index
        }

        val ans = index - left(h) + 1

        val a = visit(node.left, h + 1, 2 * index)
        val b = visit(node.right, h + 1, 2 * index + 1)

        ans max a max b
      }
    }

    val res = visit(root, 0, 1)

    res
  }
}
