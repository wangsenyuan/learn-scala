package set0000.set100.set110.p114

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "work" in {
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.left.left = new TreeNode(3)
    root.left.right = new TreeNode(4)
    root.right = new TreeNode(5)
    root.right.right = new TreeNode(6)
    Solution.flatten(root)
    root.left should be(null)
    root.right should not be (null)
    root.right.value should be(2)
  }
}
