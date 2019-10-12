package set0000.set900.set970.p979

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val root = new TreeNode(0)
    root.left = new TreeNode(3)
    root.right = new TreeNode(0)
    Solution.distributeCoins(root) should be(3)
  }

  "example two" should "work" in {
    val root = new TreeNode(4)
    root.left = new TreeNode(0)
    root.left.right = new TreeNode(0)
    root.left.right.right = new TreeNode(0)
    Solution.distributeCoins(root) should be(6)
  }
}
