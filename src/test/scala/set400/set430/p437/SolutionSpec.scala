package set400.set430.p437

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "get 3" in {
    val root = new TreeNode(10)
    root.left = new TreeNode(5)
    root.left.left = new TreeNode(3)
    root.left.left.left = new TreeNode(3)
    root.left.left.right = new TreeNode(-2)
    root.left.right = new TreeNode(2)
    root.left.right.right = new TreeNode(1)
    root.right = new TreeNode(-3)
    root.right.right = new TreeNode(11)

    val res = Solution.pathSum(root, 8)
    res should be(3)
  }

  "example two" should "get 3" in {
    val root = new TreeNode(5)
    root.left = new TreeNode(4)
    root.right = new TreeNode(8)
    root.left.left = new TreeNode(11)
    root.right.left = new TreeNode(13)
    root.right.right = new TreeNode(4)
    root.left.left.left = new TreeNode(7)
    root.left.left.right = new TreeNode(2)
    root.right.left.left = new TreeNode(5)
    root.right.left.right = new TreeNode(1)

    val res = Solution.pathSum(root, 22)
    res should be(3)
  }
}
