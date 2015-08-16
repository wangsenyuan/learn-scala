package codejam.year2008.wf

import codejam.FileOp

/**
 * Created by senyuanwang on 15/8/8.
 */
object C extends App with FileOp {

  def total(nums: Array[Int]): Int = {
    val n = nums.length
    var res = 0
    if (n % 3 == 1 || n % 3 == 2) {
      for {
        i <- 0 until n by 3
      } {
        res += nums(i)
      }
    } else {
      for {
        i <- 1 until n by 3
      } {
        res += nums(i)
      }
    }

    res
  }

  def center1(nums: Array[Int], total: Int): Int = {
    val n = nums.length
    var sum = 0
    for {
      i <- 1 until n / 2 by 3
    } {
      sum += nums(i)
      sum += nums(n - i - 1)
    }
    total - sum
  }

  def center2(nums: Array[Int], total: Int): Int = {
    val n = nums.length
    var sum = 0
    for {
      i <- 0 until n / 2 by 3
    } {
      sum += nums(i)
      sum += nums(n - i - 1)
    }
    total - sum
  }

  def center3(nums: Array[Int], total: Int): Int = {
    val n = nums.length
    var sum = 0
    for {
      i <- 0 until n / 2 by 3
    } {
      sum += nums(i)
      sum += nums(n - i - 1)
    }
    sum - total
  }

  def center(nums: Array[Int]): Int = {
    val n = nums.length
    val sum = total(nums)
    if(n % 3 == 1) center1(nums, sum)
    else if(n % 3 == 2) center2(nums, sum)
    else center3(nums, sum)
  }

  def solve(board: Array[Array[Int]]): Int = {
    val nums = board.map(total)
    center(nums)
  }

  override val filePrefix = "src/main/scala/codejam/year2008/wf/C-large-practice"

  val T = file.next().toInt

  for {
    t <- 1 to T
  } {
    val line = file.next().split("\\s+")
    val m = line(0).toInt
    val n = line(1).toInt
    val board = Array.fill(m, n)(0)

    for {
      i <- 0 until m
    } {
      val row = file.next().split("\\s+").map(_.toInt)
      for {
        j <- 0 until n
      } {
        board(i)(j) = row(j)
      }
    }

    val ans = solve(board)
    println(s"Case #$t: $ans")
  }
}
