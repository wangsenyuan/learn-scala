package set600.set650.p654

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
    val n = nums.length
    val dp = Array.ofDim[Int](n, n)

    nums.indices.foreach(i => dp(i)(i) = i)

    var i = 0
    while (i < n) {
      var j = i + 1
      while (j < n) {
        dp(i)(j) = dp(i)(j - 1)
        if (nums(j) > nums(dp(i)(j - 1))) {
          dp(i)(j) = j
        }
        j += 1
      }

      i += 1
    }

    def loop(i: Int, j: Int): TreeNode = {
      if (i == j) {
        null
      } else if (i + 1 == j) {
        new TreeNode(nums(i))
      } else {
        val k = dp(i)(j - 1)
        val root = new TreeNode(nums(k))
        root.left = loop(i, k)
        root.right = loop(k + 1, j)
        root
      }
    }

    loop(0, nums.length)
  }
}
