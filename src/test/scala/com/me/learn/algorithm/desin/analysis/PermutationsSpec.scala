package com.me.learn.algorithm.desin.analysis

import com.me.learn.algorithm.design.analysis.Permutations
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by senyuanwang on 15/6/12.
 */
class PermutationsSpec extends FlatSpec with Matchers {

  implicit val orderList = new Ordering[List[Int]] {
    override def compare(x: List[Int], y: List[Int]): Int = {
      def go(xs: List[Int], ys: List[Int]): Int =
        (xs, ys) match {
          case (Nil, Nil) => 0
          case (x :: xtail, y :: ytail) if (x > y) => 1
          case (x :: xtail, y :: ytail) if (x < y) => -1
          case (x :: xtail, y :: ytail) => go(xtail, ytail)
        }
      go(x, y)
    }
  }

  "johnsonTrotter generate permutations on 3" should "get 6 sets" in {
    Permutations.johnsonTrotter(3) should be(List(List(0, 1, 2), List(0, 2, 1), List(2, 0, 1),
      List(2, 1, 0), List(1, 2, 0), List(1, 0, 2)))
  }

  "johnsonTrotter generate permutations on 2" should "get 2 sets" in {
    Permutations.johnsonTrotter(2) should be(List(List(0, 1), List(1, 0)))
  }

  "lexicographic permute 2" should "get a lexicographic ordered sequences" in {
    Permutations.lexicographicPermute(2) should be(List(List(0, 1), List(1, 0)))
  }

  "lexicographic permute 3" should "get a lexicographic ordered sequences" in {
    Permutations.lexicographicPermute(3) should be(List(List(0, 1, 2), List(0, 2, 1),
      List(1, 0, 2), List(1, 2, 0), List(2, 0, 1), List(2, 1, 0)))
  }

  "lexicographic permute 4" should "get a lexicographic ordered sequences" in {
    Permutations.lexicographicPermute(4) should be(Permutations.johnsonTrotter(4).sorted)
  }

  "lexicographic permute 5" should "get a lexicographic ordered sequences" in {
    Permutations.lexicographicPermute(5) should be(Permutations.johnsonTrotter(5).sorted)
  }

  "generating subsets with brgc on 2" should "get 4 subsets" in {
    Permutations.brgc(2) should be(List(List(0, 0), List(0, 1), List(1, 1), List(1, 0)))
  }
}
