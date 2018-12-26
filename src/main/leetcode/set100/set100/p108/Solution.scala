package set100.set100.p108

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    if (nums.isEmpty) {
      null
    } else if (nums.length == 1) {
      new TreeNode(nums(0))
    } else {
      val mid = nums.length / 2
      val root = new TreeNode(nums(mid))
      root.left = sortedArrayToBST(nums.slice(0, mid))
      root.right = sortedArrayToBST(nums.slice(mid + 1, nums.length))
      root
    }
  }
}
