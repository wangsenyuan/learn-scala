package set0000.set100.set110.p113

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    def go(node: TreeNode, res: Int, cur: List[Int]): List[List[Int]] = {
      if (node == null) {
        Nil
      } else {
        val nums = node.value :: cur
        val newRes = node.value + res
        if (node.left == null && node.right == null) {
          if (newRes == sum) {
            List(nums.reverse)
          } else {
            Nil
          }
        } else if (node.left != null && node.right != null) {
          go(node.left, newRes, nums) ++ go(node.right, newRes, nums)
        } else if (node.left != null) {
          go(node.left, newRes, nums)
        } else {
          go(node.right, newRes, nums)
        }
      }
    }

    go(root, 0, Nil)
  }
}
