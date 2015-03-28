package maxgap

/**
 * Created by senyuanwang on 15/3/20.
 */
object App extends App {

  def maximumGap(nums: Array[Int]): Int = {
    val n = nums.length

    def minMax(i: Int, a: Int, b: Int): (Int, Int) =
      if (i >= n) (a, b)
      else {
        minMax(i + 1, a min nums(i), b max nums(i))
      }

    val (a, b) = minMax(0, Int.MaxValue, Int.MinValue)

    val bucketsLen = (b - a) / (n - 1)
    val bucketsNum = (b - a) / bucketsLen + 1

    val bucketsA = Array.fill(bucketsNum)(b + 1)
    val bucketsB = Array.fill(bucketsNum)(a - 1)

    def placeNum(i: Int): Unit =
      if (i < n) {
        val num = nums(i)
        val index = (num - a) / bucketsLen

        bucketsA(index) = bucketsA(index) min num
        bucketsB(index) = bucketsB(index) max num

        placeNum(i + 1)
      }

    placeNum(0)

    def findMaxGap(i: Int, prevMax: Int, maxGap: Int): Int =
      if (i >= n) {
        maxGap
      } else if (bucketsA(i) > b) {
        //this bucket is empty
        findMaxGap(i + 1, prevMax, maxGap)
      } else {
        findMaxGap(i + 1, bucketsB(i), maxGap max (bucketsA(i) - prevMax))
      }

    findMaxGap(1, bucketsB(0), bucketsLen)
  }

//  println(maximumGap(Array(1, 10000000)))

  println(maximumGap(Array(15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740)))
}
