package geeks.lca

import org.scalatest.FlatSpec

/**
 * Created by senyuanwang on 15/6/8.
 */
class TreeSpec extends FlatSpec {
  val tree = new Tree(8)
  tree.addEdge(0, 1)
  tree.addEdge(0, 2)
  tree.addEdge(1, 3)
  tree.addEdge(1, 4)
  tree.addEdge(2, 5)
  tree.addEdge(4, 6)
  tree.addEdge(4, 7)

  "find LCA of 3 and 6 with direct search" should "be 1" in {
    assert(tree.lca0(3, 6) == 1)
  }

  "find LCA of 3 and 6 with binary search" should "be 1" in {
    assert(tree.lca1(3, 6) == 1)
  }


}
