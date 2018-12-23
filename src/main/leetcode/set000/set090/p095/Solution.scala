package set000.set090.p095


/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def generateTrees(n: Int): List[TreeNode] = {
    if (n == 0) {
      Nil
    } else {
      val nums = (1 to n).toArray

      def go(left: Int, right: Int): List[TreeNode] = {
        if (left == right) {
          List(null)
        } else if (left + 1 == right) {
          List(new TreeNode(nums(left)))
        } else {
          var res = List.empty[TreeNode]
          var idx = left
          while (idx < right) {
            val ll = go(left, idx)
            val rr = go(idx + 1, right)

            res ++= (for {
              l <- ll
              r <- rr
            } yield {
              val root = new TreeNode(nums(idx))
              root.left = l
              root.right = r
              root
            })

            idx += 1
          }
          res
        }
      }

      go(0, n)
    }
  }
}
