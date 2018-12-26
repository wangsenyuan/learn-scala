package set100.set100.p109

/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def sortedListToBST(head: ListNode): TreeNode = {
    def go(head: ListNode, n: Int): TreeNode = {
      if (n == 0) {
        null
      } else if (n == 1) {
        new TreeNode(head.x)
      } else {
        val mid = n / 2
        val node = seek(head, mid)
        val root = new TreeNode(node.x)
        root.left = go(head, mid)
        root.right = go(node.next, n - 1 - mid)
        root
      }
    }

    go(head, size(head))
  }

  private def size(node: ListNode): Int = {
    if (node == null) {
      0
    } else {
      1 + size(node.next)
    }
  }

  private def seek(node: ListNode, n: Int): ListNode = {
    if (n == 0) {
      node
    } else {
      seek(node.next, n - 1)
    }
  }
}
