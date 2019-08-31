package set0000.set800.set890.p894


/**
 * Definition for a binary tree node.
 */

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}


object Solution {

  import scala.collection.mutable
  import scala.collection.mutable.ListBuffer

  def allPossibleFBT(N: Int): List[TreeNode] = {
    val mem = mutable.Map.empty[Int, List[TreeNode]]

    def loop(n: Int): List[TreeNode] = {
      if (n == 0) {
        Nil
      } else if (n == 1) {
        List(new TreeNode(0))
      } else if (mem.contains(n)) {
        mem(n)
      } else {
        val res = ListBuffer.empty[TreeNode]
        var i = 0
        while (i <= n - 1) {
          val left = loop(i)
          val right = loop(n - 1 - i)
          for {
            l <- left
            r <- right
          } {
            val root = new TreeNode(0)

            root.left = l
            root.right = r

            res += root
          }
          i += 1
        }

        mem(n) = res.toList

        mem(n)
      }
    }

    loop(N)
  }
}
