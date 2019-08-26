package set0000.set400.set430.p437

/**
  * Definition for a binary tree node.
  **/
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def pathSum(root: TreeNode, sum: Int): Int = {

    def go(node: TreeNode, ans: Int, freq: Map[Int, Int]): Int = {
      if (node == null) {
        0
      } else {
        val x = ans + node.value
        val y =
          if (freq.contains(x - sum)) {
            freq(x - sum)
          } else {
            0
          }
        val newFreq = updateFreq(freq, x)
        y + go(node.left, x, newFreq) + go(node.right, x, newFreq)
      }
    }

    go(root, 0, Map(0 -> 1))
  }

  private def updateFreq(freq: Map[Int, Int], x: Int): Map[Int, Int] = {
    if(freq.contains(x)) {
      freq + (x -> (freq(x) + 1))
    } else {
      freq + (x -> 1)
    }
  }
}
