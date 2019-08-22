package set800.set860.p863


/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {

  import scala.collection.mutable.ListBuffer

  def distanceK(root: TreeNode, target: TreeNode, K: Int): List[Int] = {
    if (K == 0) {
      List(target.value)
    } else {
      val res = ListBuffer.empty[TreeNode]

      def find(node: TreeNode): Int = {
        if (node != null) {
          if (node == target) {
            findNodesAtDist(node, K, res)
            0
          } else {
            val a = find(node.left)
            val b = find(node.right)
            if (a < 0 && b < 0) {
              -1
            } else if (a + 1 == K || b + 1 == K) {
              res += node
              K
            } else if (a >= 0) {
              findNodesAtDist(node.right, K - a - 2, res)
              1 + a
            } else {
              findNodesAtDist(node.left, K - b - 2, res)
              1 + b
            }
          }
        } else {
          -1
        }
      }

      find(root)

      res.map(_.value).toList
    }
  }

  private def findNodesAtDist(node: TreeNode, d: Int, res: ListBuffer[TreeNode]): Unit = {
    if (node != null && d >= 0) {
      if (d == 0) {
        res += node
      } else {
        findNodesAtDist(node.left, d - 1, res)
        findNodesAtDist(node.right, d - 1, res)
      }
    }
  }
}
