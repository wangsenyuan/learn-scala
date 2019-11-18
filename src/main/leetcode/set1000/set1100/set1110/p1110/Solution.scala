package set1000.set1100.set1110.p1110

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
  import scala.collection.mutable.ListBuffer

  def delNodes(root: TreeNode, to_delete: Array[Int]): List[TreeNode] = {
    val set = to_delete.toSet

    val buf = ListBuffer.empty[TreeNode]
    val added = mutable.Set.empty[Int]

    def dfs(node: TreeNode): TreeNode = {
      if (node == null) {
        null
      } else {
        node.left = dfs(node.left)
        node.right = dfs(node.right)
        if (!set.contains(node.value)) {
          // no need to delete
          node
        } else {
          if (node.left != null && !added.contains(node.left.value)) {
            buf += node.left
            added += node.left.value
          }
          if (node.right != null && !added.contains(node.right.value)) {
            buf += node.right
            added += node.right.value
          }
          null
        }
      }
    }

    val newRoot = dfs(root)

    if (newRoot != null) {
      buf += newRoot
    }

    buf.toList
  }
}
