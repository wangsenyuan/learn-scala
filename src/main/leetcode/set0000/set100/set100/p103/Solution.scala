package set0000.set100.set100.p103

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    def go(prev: List[TreeNode], forward: Boolean, res: List[List[Int]]): List[List[Int]] = {
      if (prev.isEmpty) {
        res.reverse
      } else {
        var level = List.empty[TreeNode]
        var nums = List.empty[Int]
        prev.foreach {
          case node =>
            nums = node.value :: nums
            if (node.left != null) {
              level = node.left :: level
            }
            if (node.right != null) {
              level = node.right :: level
            }
        }


        if (forward) {
          go(level.reverse, false, nums.reverse :: res)
        } else {
          go(level.reverse, true, nums :: res)
        }
      }
    }

    if (root == null) {
      Nil
    } else {
      go(List(root), true, Nil)
    }
  }
}
