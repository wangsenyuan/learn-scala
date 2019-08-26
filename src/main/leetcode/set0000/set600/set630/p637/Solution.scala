package set0000.set600.set630.p637

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
  def averageOfLevels(root: TreeNode): Array[Double] = {
    val sum = ArrayBuffer.empty[Long]
    val cnt = ArrayBuffer.empty[Long]

    def visit(node: TreeNode, d: Int): Unit = {
      if(node != null) {
        if(sum.length > d) {
          sum(d) += node.value
          cnt(d) += 1
        } else {
          sum += node.value
          cnt += 1
        }
        visit(node.left, d + 1)
        visit(node.right, d + 1)
      }
    }
    visit(root, 0)

    sum.toArray.zip(cnt).map {
      case (s, c) => s.toDouble / c.toDouble
    }
  }
}
