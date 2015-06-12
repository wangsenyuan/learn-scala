package com.me.learn.algorithm.desin.analysis

import com.me.learn.algorithm.design.analysis.Permutations
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by senyuanwang on 15/6/12.
 */
class PermutationsSpec extends FlatSpec with Matchers {

  "johnsonTrotter generate permutations on 3" should "get 6 sets" in {
    Permutations.johnsonTrotter(3) should be(List(List(0, 1, 2), List(0, 2, 1), List(2, 0, 1),
      List(2, 1, 0), List(1, 2, 0), List(1, 0, 2)))
  }

  "johnsonTrotter generate permutations on 2" should "get 2 sets" in {
    Permutations.johnsonTrotter(2) should be(List(List(0, 1), List(1, 0)))
  }
}
