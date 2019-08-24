package set800.set870.p872


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

  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
    val a = getLeafValues(root1)
    val b = getLeafValues(root2)
    (a.length == b.length) && a.zip(b).forall(x => x._1 == x._2)
  }

  private def getLeafValues(root: TreeNode): List[Int] = {
    val buf = ListBuffer.empty[Int]

    def loop(node: TreeNode): Unit = {
      if (node != null) {
        if (node.left == null && node.right == null) {
          buf += node.value
        }
        loop(node.left)
        loop(node.right)
      }
    }

    loop(root)

    buf.toList
  }
}
