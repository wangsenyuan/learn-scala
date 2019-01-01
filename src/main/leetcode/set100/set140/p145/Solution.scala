package set100.set140.p145


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

  def postorderTraversal(root: TreeNode): List[Int] = {
    val res = ListBuffer.empty[Int]

    def go(root: TreeNode): Unit = {
      if (root != null) {
        go(root.left)
        go(root.right)
        res += root.value
      }
    }

    go(root)

    res.toList
  }
}
