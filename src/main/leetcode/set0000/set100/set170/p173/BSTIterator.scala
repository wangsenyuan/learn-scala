package set0000.set100.set170.p173

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

class BSTIterator(_root: TreeNode) {
  private var stacks = List.empty[TreeNode]

  var node = _root
  while (node != null) {
    stacks = node :: stacks
    node = node.left
  }

  /** @return the next smallest number */
  def next(): Int = {
    val top = stacks.head
    stacks = stacks.tail
    var node = top.right

    while (node != null) {
      stacks = node :: stacks
      node = node.left
    }

    top.value
  }

  /** @return whether we have a next smallest number */
  def hasNext(): Boolean = {
    stacks.size > 0
  }

}
