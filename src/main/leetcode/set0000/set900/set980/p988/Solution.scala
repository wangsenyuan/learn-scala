package set0000.set900.set980.p988


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

  def smallestFromLeaf(root: TreeNode): String = {

    val buf = ArrayBuffer.empty[String]

    def dfs(node: TreeNode, res: String): Unit = {
      val s = res + (node.value + 'a').toChar
      if (node.left == null && node.right == null) {
        buf += s
      } else if (node.left == null) {
        dfs(node.right, s)
      } else if (node.right == null) {
        dfs(node.left, s)
      } else {
        dfs(node.left, s)
        dfs(node.right, s)
      }
    }

    dfs(root, "")

    val res = buf.map(_.reverse).sorted

    res(0)
  }

  private def compare(a: String, b: String): Boolean = {
    if (a.isEmpty) {
      true
    } else if (b.isEmpty) {
      false
    } else if (a.head < b.head) {
      true
    } else if (a.head == b.head) {
      compare(a.tail, b.tail)
    } else {
      false
    }
  }

}
