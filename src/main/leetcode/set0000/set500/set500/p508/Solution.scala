package set0000.set500.set500.p508


/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

import scala.collection.mutable

object Solution {
  def findFrequentTreeSum(root: TreeNode): Array[Int] = {
    if (root == null) {
      Array()
    } else {
      val cnt = mutable.Map.empty[Int, Int].withDefaultValue(0)

      def go(node: TreeNode): Int = {
        if (node == null) {
          0
        } else {
          val temp = go(node.left) + node.value + go(node.right)
          cnt(temp) += 1
          temp
        }
      }

      go(root)

      val nums = cnt.toArray

      val most = nums.maxBy(_._2)._2
      nums.filter(_._2 == most).map(_._1)
    }
  }

}
