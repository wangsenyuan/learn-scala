package com.me.problem.rmq

/**
  * Created by wangsenyuan on 16/12/2016.
  */
object Main {


}

trait RMQ {
  val nums: Array[Int]

  def query(i: Int, j: Int): Int
}

object RMQ {
  def log2(x: Int): Int = {
    def go(i: Int, y: Int): Int = {
      if (2 * y > x) {
        i
      } else {
        go(i + 1, 2 * y)
      }
    }

    go(0, 1)
  }
}

class TrivalRMQ(override val nums: Array[Int]) extends RMQ {
  val n = nums.length
  private val minIndexTable: Array[Array[Int]] = Array.fill(n, n)(-1)

  for {
    i <- 0 until n
  } {
    minIndexTable(i)(i) = i
  }

  for {
    i <- 0 until n
    j <- i + 1 until n
  } {
    if (nums(minIndexTable(i)(j - 1)) < nums(j)) {
      minIndexTable(i)(j) = minIndexTable(i)(j - 1)
    } else {
      minIndexTable(i)(j) = j
    }
  }

  def query(i: Int, j: Int) = {
    require(i >= 0 && i < nums.length)
    require(j >= i && j < nums.length)
    nums(minIndexTable(i)(j))
  }
}


class SparseTableRMQ(override val nums: Array[Int]) extends RMQ {

  import RMQ._

  val n = nums.length
  val logn = log2(n) + 1
  val sparseTable = Array.fill(n, logn)(-1)

  for {
    i <- 0 until n
  } {
    sparseTable(i)(0) = i
  }

  for {
    j <- 1 until logn
    if (1 << j) <= n
    i <- 0 until (n + 1 - (1 << j))
  } {
    if (nums(sparseTable(i)(j - 1)) < nums(sparseTable(i + (1 << (j - 1)))(j - 1))) {
      sparseTable(i)(j) = sparseTable(i)(j - 1)
    } else {
      sparseTable(i)(j) = sparseTable(i + (1 << (j - 1)))(j - 1)
    }
  }

  def query(i: Int, j: Int) = {
    require(i >= 0 && i < nums.length)
    require(j >= i && j < nums.length)
    val k = log2(j - i + 1)
    if (nums(sparseTable(i)(k)) <= nums(sparseTable(j - (1 << k) + 1)(k))) {
      nums(sparseTable(i)(k))
    } else {
      nums(sparseTable(j - (1 << k) + 1)(k))
    }
  }
}

class SegmentTreeRMQ(override val nums: Array[Int]) extends RMQ {

  import RMQ._

  val n = nums.length
  val logn = log2(n) + 1
  val tree = Array.fill(2 * (1 << logn))(-1)

  private def init(node: Int, b: Int, e: Int): Int = {
    if (b == e) {
      tree(node) = b
    } else {
      val left = init(2 * node, b, (b + e) / 2)
      val right = init(2 * node + 1, (b + e) / 2 + 1, e)
      if (nums(left) <= nums(right)) {
        tree(node) = left
      } else {
        tree(node) = right
      }
    }

    tree(node)
  }

  init(1, 0, n - 1)


  private def query(node: Int, b: Int, e: Int, i: Int, j: Int): Int = {
    if (i > e || j < b) {
      -1
    } else if (i <= b && e <= j) {
      tree(node)
    } else {
      val left = query(2 * node, b, (b + e) / 2, i, j)
      val right = query(2 * node + 1, (b + e) / 2 + 1, e, i, j)
      if (left == -1) {
        right
      } else if (right == -1) {
        left
      } else if (nums(left) <= nums(right)) {
        left
      } else {
        right
      }
    }
  }

  def query(i: Int, j: Int): Int = {
    require(i >= 0 && i < nums.length)
    require(j >= i && j < nums.length)
    val idx = query(1, 0, n - 1, i, j)
    nums(idx)
  }
}
