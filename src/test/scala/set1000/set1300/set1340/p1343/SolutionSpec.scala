package set1000.set1300.set1340.p1343

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.right = new TreeNode(3)
    root.left.left = new TreeNode(4)
    root.left.right = new TreeNode(5)
    root.right.left = new TreeNode(6)
    val res = Solution.maxProduct(root)
    res should be(110)
  }
}
