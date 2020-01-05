package set1000.set1300.set1300.p1305


/**
 * Definition for a binary tree node.
 **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  import scala.collection.mutable.ArrayBuffer

  def getAllElements(root1: TreeNode, root2: TreeNode): List[Int] = {
    val a = getElements(root1)
    val b = getElements(root2)
    val res = Array.ofDim[Int](a.length + b.length)
    var i = 0
    var j = 0
    while (i < a.length || j < b.length) {
      if (i == a.length || (j < b.length && b(j) < a(i))) {
        res(i + j) = b(j)
        j += 1
      } else {
        res(i + j) = a(i)
        i += 1
      }
    }
    res.toList
  }

  private def getElements(node: TreeNode): Array[Int] = {
    val buf = ArrayBuffer.empty[Int]

    def dfs(node: TreeNode): Unit = {
      if (node != null) {
        dfs(node.left)
        buf += node.value
        dfs(node.right)
      }
    }

    dfs(node)

    buf.toArray
  }
}
