package com.me.learn

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by senyuanwang on 15/6/11.
 */
class SortSpec extends FlatSpec with Matchers {

  "quick sort 1 4 3 2" should "get 1 2 3 4" in {
    Sort.quickSort(List(1, 4, 3, 2)) should be(List(1, 2, 3, 4))
  }

  "bubble sort 1 4 3 2" should "get 1 2 3 4" in {
    Sort.bubbleSort(List(1, 4, 3, 2)) should be(List(1, 2, 3, 4))
  }

  "insert sort 1 4 3 2" should "get 1 2 3 4" in {
    Sort.insertSort(List(1, 4, 3, 2)) should be(List(1, 2, 3, 4))
  }
}
