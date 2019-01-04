package set100.set160.p164

/**
  * Created by senyuanwang on 15/3/20.
  */
object Solution extends App {

  def maximumGap(nums: Array[Int]): Int = {
    val n = nums.length
    if (n < 2) {
      0
    } else {
      val min = nums.min
      val max = nums.max
      if (min == max) {
        0
      } else {
        val bucketSize = 1 max (max - min) / (n - 1)
        val bucketNum = (max - min) / bucketSize + 1
        //        val buckets = Array.ofDim[Bucket](bucketNum)
        val used = Array.fill(bucketNum)(false)
        val mins = Array.fill(bucketNum)(Int.MaxValue)
        val maxs = Array.fill(bucketNum)(Int.MinValue)


        nums.foreach {
          case num =>
            val index = (num - min) / bucketSize
            mins(index) = mins(index) min num
            maxs(index) = maxs(index) max num
            used(index) = true
        }

        var best = 0
        var prev = min
        for {
          i <- 0 until bucketNum
          if used(i)
        } {
          best = best max (mins(i) - prev)
          prev = maxs(i)
        }
        best
      }
    }
  }

  def maximumGap2(nums: Array[Int]): Int = {
    val n = nums.length
    if (n < 2) {
      0
    } else {
      val max = nums.max
      var exp = 1
      val aux = Array.ofDim[Int](n)
      val count = Array.fill(10)(0)

      while (max / exp > 0) {
        for {
          i <- 0 until 10
        } {
          count(i) = 0
        }
        nums.foreach(num => count((num / exp) % 10) += 1)
        for {
          i <- 1 until 10
        } {
          count(i) += count(i - 1)
        }
        for {
          i <- (n - 1) to 0 by -1
        } {
          val j = (nums(i) / exp) % 10
          count(j) -= 1
          aux(count(j)) = nums(i)
        }

        for {
          i <- 0 until n
        } {
          nums(i) = aux(i)
        }
        exp *= 10
      }
      var best = 0
      var i = 1
      while (i < n) {
        best = best max (nums(i) - nums(i - 1))
        i += 1
      }
      best
    }
  }


  def maximumGap1(nums: Array[Int]): Int = {
    val xs = nums.sorted
    var i = 1
    var best = 0
    while (i < xs.length) {
      best = best max (xs(i) - xs(i - 1))

      i += 1
    }
    best
  }

  //  println(maximumGap(Array(1, 10000000)))

  println(maximumGap(Array(15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740)))
}
