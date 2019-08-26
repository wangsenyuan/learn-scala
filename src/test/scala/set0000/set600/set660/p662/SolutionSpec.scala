package set0000.set600.set660.p662

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.right = new TreeNode(3)
    root.left.left = new TreeNode(4)
    root.right.right = new TreeNode(5)
    val res = Solution.widthOfBinaryTree(root)
    res should be(4)
  }
}
