package set100.set110.p112

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "5,4,8,11,null,13,4,7,2,null,null,null,1 and 22" should "get true" in {
    val root = new TreeNode(5)
    root.left = new TreeNode(4)
    root.left.right = new TreeNode(11)
    root.left.right.right = new TreeNode(2)
    val res = Solution.hasPathSum(root, 22)
    res should be(true)
  }
}
