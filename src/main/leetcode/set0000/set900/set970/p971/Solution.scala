package set0000.set900.set970.p971


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

  def flipMatchVoyage(root: TreeNode, voyage: Array[Int]): List[Int] = {
    val n = voyage.length
    val ii = Array.ofDim[Int](n + 1)

    (0 until n).foreach(i => ii(voyage(i)) = i)

    val buf = ListBuffer.empty[Int]

    def loop(node: TreeNode, i: Int, j: Int): Boolean = {
      if (i > j) {
        false
      } else if (node == null) {
        i == j
      } else if (node.value != voyage(i)) {
        false
      } else {
        // try not to rotate first
        if (node.right == null) {
          loop(node.left, i + 1, j)
        } else if (node.left == null) {
          loop(node.right, i + 1, j)
        } else {
          // left != null && right != null
          var res = loop(node.left, i + 1, ii(node.right.value)) && loop(node.right, ii(node.right.value), j)
          if (!res) {
            buf += node.value
            res = loop(node.right, i + 1, ii(node.left.value)) && loop(node.left, ii(node.left.value), j)
          }

          res
        }
      }
    }

    val res = loop(root, 0, n)

    if (res) {
      buf.toList
    } else {
      List(-1)
    }
  }
}
