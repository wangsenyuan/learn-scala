package set0000.set900.set910.p919

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val target = new Solution.CBTInserter(new Solution.TreeNode(1))
    val res = target.insert(2)
    res should be(1)
  }

  "example two" should "work" in {
    val root = new Solution.TreeNode(1)
    root.left = new Solution.TreeNode(2)
    root.right = new Solution.TreeNode(3)
    root.left.left = new Solution.TreeNode(4)
    root.left.right = new Solution.TreeNode(5)
    root.right.left = new Solution.TreeNode(6)

    val target = new Solution.CBTInserter(root)

    target.insert(7) should be(3)
    target.insert(8) should be(4)
  }
}
