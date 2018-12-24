package set100.set100.p102

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) {
      Nil
    } else {

      def go(prev: List[TreeNode], res: List[List[Int]]): List[List[Int]] = {
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

          go(level.reverse, nums.reverse :: res)
        }
      }

      go(List(root), Nil)
    }
  }
}
