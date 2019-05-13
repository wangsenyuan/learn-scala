package set600.set650.p652

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.left.left = new TreeNode(4)
    root.right = new TreeNode(3)
    root.right.left = new TreeNode(2)
    root.right.left.left = new TreeNode(4)
    root.right.right = new TreeNode(4)
    val res = Solution.findDuplicateSubtrees(root)
    res.size should be(2)
  }

  "example two" should "work" in {
    val root = new TreeNode(0)
    root.left = new TreeNode(0)

    def mock(): TreeNode = {
      val node = new TreeNode(0)
      node.left = new TreeNode(0)
      node.right = new TreeNode(0)
      node
    }

    root.left = mock()
    root.right = mock()

    val res = Solution.findDuplicateSubtrees(root)
    res.size should be(2)
  }
}
