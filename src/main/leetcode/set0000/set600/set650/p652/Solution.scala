package set0000.set600.set650.p652


/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {
  def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {

    val count = mutable.Map.empty[String, Int].withDefaultValue(0)

    val res = ListBuffer.empty[TreeNode]


    def visit(node: TreeNode): String = {
      if(node == null) {
        "()"
      } else {
        val key = "(" + node.value + visit(node.left) + visit(node.right) + ")"
        count(key) += 1
        if(count(key) == 2) {
          res += node
        }
        key
      }
    }

    visit(root)

    res.toList
  }

}
