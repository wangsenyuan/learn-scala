package set1000.set1100.set1160.p1161

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val root = new TreeNode(1)
    root.left = new TreeNode(7)
    root.right = new TreeNode(0)
    root.left.left = new TreeNode(7)
    root.left.right = new TreeNode(-8)
    val res = Solution.maxLevelSum(root)
    res should be(2)
  }
}
