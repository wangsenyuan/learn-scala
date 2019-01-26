package p337.house.robber

import set200.set270.p272.TreeNode

/**
  * Created by wangsenyuan on 4/1/16.
  */
object App {

  def rob(root: TreeNode): Int = {

    def goRob(root: TreeNode): (Int, Int) = {
      if (root == null) {
        (0, 0)
      } else {
        val (leftRobbed, leftSkipped) = goRob(root.left)
        val (rightRobbed, rightSkipped) = goRob(root.right)
        val rootRobbed = root.`val` + leftSkipped + rightSkipped
        val rootSkipped = leftRobbed + rightRobbed
        (rootRobbed max rootSkipped, leftRobbed + rightRobbed)
      }
    }

    goRob(root)._1
  }
}
