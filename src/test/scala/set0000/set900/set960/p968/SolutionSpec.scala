package set0000.set900.set960.p968

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val root = new TreeNode(0)
    root.left = new TreeNode(0)
    root.left.left = new TreeNode(0)
    root.left.right = new TreeNode(0)
    val res = Solution.minCameraCover(root)
    res should be(1)
  }

  "example two" should "work" in {
    val root = new TreeNode(0)
    root.right = new TreeNode(1)
    root.right.right = new TreeNode(2)
    root.right.right.left = new TreeNode(3)
    root.right.right.right = new TreeNode(4)
    val res = Solution.minCameraCover(root)
    res should be(2)
  }
}
