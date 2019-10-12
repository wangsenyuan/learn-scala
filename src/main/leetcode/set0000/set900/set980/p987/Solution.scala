package set0000.set900.set980.p987


/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {

  import scala.collection.mutable
  import scala.collection.mutable.ArrayBuffer

  def verticalTraversal(root: TreeNode): List[List[Int]] = {
    if (root == null) {
      List(Nil)
    } else {

      val mem = mutable.Map.empty[Int, ArrayBuffer[(Int, Int)]]


      def visit(node: TreeNode, x: Int, y: Int): Unit = {
        if (node != null) {
          visit(node.left, x - 1, y + 1)

          if (!mem.contains(x)) {
            mem += x -> ArrayBuffer.empty[(Int, Int)]
          }

          mem(x) += y -> node.value

          visit(node.right, x + 1, y + 1)
        }
      }

      visit(root, 0, 0)

      val arr = mem.toArray
      arr.sortBy(_._1).map(_._2.sortWith(compare).map(_._2).toList).toList
    }
  }

  private def compare(a: (Int, Int), b: (Int, Int)): Boolean = {
    if (a._1 < b._1) {
      true
    } else if (a._1 == b._1) {
      a._2 < b._2
    } else {
      false
    }
  }
}
